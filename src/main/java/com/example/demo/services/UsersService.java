package com.example.demo.services;

import com.example.demo.models.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    public Iterable<Users> findAll();

    public Users createUser(Users users);

    public void deleteById(int id);

    public Optional<Users> findById(int id);

    public void updateUser(Users users);

    public List<Users> findByName(String keyword);

}
