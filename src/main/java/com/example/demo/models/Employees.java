package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false, unique = true)
    private Integer id;

    @NotEmpty(message = "Name field should not be empty")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Email field should not be empty")
    @Email(regexp = "^(.+)@(.+)$", message = "Invalid email pattern")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Skills field should not be empty")
    @Column(name = "skills")
    private String skills;

    @NotEmpty(message = "CV field should not be empty")
    @Column(name = "cv")
    private String cv;

    @NotEmpty(message = "Linkedin field should not be empty")
    @Column(name = "linkedin")
    private String linkedin;

    @NotEmpty(message = "Level field should not be empty")
    @Column(name = "level")
    private String level;
}

