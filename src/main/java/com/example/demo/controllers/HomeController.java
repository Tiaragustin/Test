package com.example.demo.controllers;

import com.example.demo.dto.Search;
import com.example.demo.models.Users;
import com.example.demo.repos.UsersRepo;
import com.example.demo.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    UsersService usersService;

    @Autowired
    UsersRepo usersRepo;

    @GetMapping("/")
    public String home(){
        return "home";
    }


    @GetMapping("/getUsers")
    public String getUsers(Model model){
        model.addAttribute("search", new Search());
        model.addAttribute("users", usersService.findAll());
        return "index";
    }

    @GetMapping("/createUser")
    public String createUser(Model model){
        model.addAttribute("users", new Users());

        return "create";
    }

    @PostMapping("/save")
    public String save(@Valid Users users, Errors errors, Model model){
        if (errors.hasErrors()) {
            return "create";
        } else {
            usersService.createUser(users);
            return "redirect:/getUsers";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        usersService.deleteById(id);

        return "redirect:/getUsers";
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        model.addAttribute("users", usersService.findById(id));

        return "update";
    }

    @PostMapping("/saveUpdate")
    public String saveUpdate(@Valid Users users, Errors errors, Model model){
        if (errors.hasErrors()) {
            return "update";
        } else {
            usersService.updateUser(users);
            return "redirect:/getUsers";
        }
    }
    @PostMapping("/search")
    public String search(Search search, Model model){
        model.addAttribute("search", search);
        model.addAttribute("users", usersService.findByName(search.getKeyword()));
        return "index";
    }

    @GetMapping("/address")
    public String address(Model model){
        model.addAttribute("users", new Users());

        return "address";
    }
}
