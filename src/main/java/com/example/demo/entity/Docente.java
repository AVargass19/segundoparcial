package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Docente {

    @Id
    @GeneratedValue

    private long id;
    private String nombre;
    private String cargo;

    @OneToMany(mappedBy = "docente")
    private List<Asignatura> asignaturas;

}
