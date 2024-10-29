package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String nombre;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;


    public String getEmail() {
        return null;
    }

    public String getPassword() {
        return null;
    }

    public Arrays getRoles() {
        return null;
    }
}
