package com.example.demo.controllers;

import com.example.demo.dto.SearchDto;
import com.example.demo.models.Employees;
import com.example.demo.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    EmployeesService employeesService;

    @GetMapping("/")
    public String getEmployees(Model model){

//        return "index";
        return findPaginated(1, model);
//        return "redirect:/page{1}";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("employees", new Employees());

        return "add";
    }

    @PostMapping("/save")
    public String save(@Valid Employees employees, Errors errors, Model model){
        if (errors.hasErrors()) {
            return "add";
        } else {
            employeesService.addEmployees(employees);
            return "redirect:/";
        }


    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeesService.deleteById(id);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        model.addAttribute("employees", employeesService.findById(id));

        return "edit";
    }

    @PostMapping("/update")
    public String update (Employees employees, Model model){
        employeesService.updateEmployees(employees);

        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(SearchDto searchDto, Model model){
        model.addAttribute("searchForm", searchDto);
        model.addAttribute("employees", employeesService.findByName(searchDto.getKeyword()));

        return "index";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id, Model model){
        model.addAttribute("employees", employeesService.findById(id));

        return "view";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<Employees> page = employeesService.findPaginated(pageNo, pageSize);
        List<Employees> listEmployees = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listEmployees", listEmployees);
        model.addAttribute("searchForm", new SearchDto());
        model.addAttribute("employees", employeesService.findAll());

        return "index";
    }
}
//    @GetMapping("/view")
//    public ModelMap view(@RequestParam(required = false, value = "id") Employees employees){
//        return new ModelMap().addAttribute("employees", employees);
//    }

