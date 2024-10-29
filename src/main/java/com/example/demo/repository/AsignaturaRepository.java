package com.example.demo.repository;

import com.example.demo.entity.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {

    List<Asignatura> findByDocenteEncargadoId(Long docenteId);

    List<Asignatura> findByNombreContaining(String nombre);

}
