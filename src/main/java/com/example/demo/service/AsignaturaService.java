package com.example.demo.service;

import com.example.demo.entity.Asignatura;
import com.example.demo.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;


    public Asignatura crearAsignatura(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    public List<Asignatura> listarAsignaturas() {
        return asignaturaRepository.findAll();
    }

    public Asignatura actualizarAsignatura(Long id, Asignatura asignaturaActualizada) {
        Asignatura asignatura = asignaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));

        asignatura.setNombre(asignaturaActualizada.getNombre());
        asignatura.setDescripcion(asignaturaActualizada.getDescripcion());
        asignatura.setSalon(asignaturaActualizada.getSalon());
        asignatura.setHoraInicio(asignaturaActualizada.getHoraInicio());
        asignatura.setHoraFin(asignaturaActualizada.getHoraFin());
        asignatura.setDocenteEncargado(asignaturaActualizada.getDocenteEncargado());

        return asignaturaRepository.save(asignatura);
    }

    public void eliminarAsignatura(Long id) {
        asignaturaRepository.deleteById(id);
    }

}


