package com.example.demo.entity;

import jakarta.persistence.*;
import org.hibernate.Length;

import java.time.LocalTime;

@Entity
public class Asignatura {

    @Id
    @GeneratedValue

    private long id;

    @Column(length = 30)
    private String nombre;

    @Column(length = 100)
    private String descripcion;

    private Integer salon;

    private LocalTime horaInicio;
    private LocalTime horaFin;

    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;
}
