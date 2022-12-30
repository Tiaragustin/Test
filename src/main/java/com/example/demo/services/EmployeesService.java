package com.example.demo.services;

import com.example.demo.models.Employees;
import com.example.demo.repos.EmployeesRepo;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {

    @Autowired
    EmployeesRepo employeesRepo;

    public Iterable<Employees> findAll(){

        return employeesRepo.findAll();
    }


    public void addEmployees(Employees employees){
        employeesRepo.save(employees);
    }

    public void deleteById(Integer id){
        employeesRepo.deleteById(id);
    }

    public Optional<Employees> findById(Integer id){
        return employeesRepo.findById(id);
    }
    
    public void updateEmployees(Employees employees){
        employeesRepo.save(employees);
    }

    public List<Employees> findByName(String keyword){
        return employeesRepo.findByNameContains(keyword);
    }

    public Page<Employees> findPaginated(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.employeesRepo.findAll(pageable);
    }

}
