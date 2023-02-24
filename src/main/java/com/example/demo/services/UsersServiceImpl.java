package com.example.demo.services;

import com.example.demo.models.Users;
import com.example.demo.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    UsersRepo usersRepo;

    @Override
    public Users createUser(Users users) {
        return usersRepo.save(users);
    }

    @Override
    public Iterable<Users> findAll() {
        return  usersRepo.findAll();
    }

    @Override
    public void deleteById(int id) {
        usersRepo.deleteById(id);
    }

    @Override
    public Optional<Users> findById(int id) {
        return usersRepo.findById(id);
    }

    @Override
    public void updateUser(Users users) {
        usersRepo.save(users);
    }

    @Override
    public List<Users> findByName(String keyword) {
        return usersRepo.findByNameContains(keyword);
    }
}
