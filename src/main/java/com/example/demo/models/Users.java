package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false, unique = true)
    private Integer id;

    @Size(max = 50, message = "Max name length is 50")
    private String name;

    @Pattern(regexp = "^\\d{10}$", message = "Phone number contain only numbers and Min phone number length is 10")
    @Size(max = 13, message = "Max phone number length is 13")
    private String noHp;

    @Email (message = "Please enter a valid email")
    private String email;

    @NotEmpty(message = "Address field should not be empty")
    private String alamat;

}
