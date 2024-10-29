package com.example.demo.controller;

import com.example.demo.entity.Asignatura;
import com.example.demo.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {
    @Autowired
    private AsignaturaService asignaturaService;

    @PreAuthorize("hasRole('RECTOR')")
    @PostMapping
    public ResponseEntity<Asignatura> crearAsignatura(@RequestBody Asignatura asignatura) {
        return ResponseEntity.ok(asignaturaService.crearAsignatura(asignatura));
    }

    @GetMapping
    public ResponseEntity<List<Asignatura>> listarAsignaturas() {
        return ResponseEntity.ok(asignaturaService.listarAsignaturas());
    }

    @PreAuthorize("hasRole('RECTOR') or (hasRole('DOCENTE') and #asignatura.docenteEncargado == authentication.name)")
    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> actualizarAsignatura(@PathVariable Long id, @RequestBody Asignatura asignatura) {
        return ResponseEntity.ok(asignaturaService.actualizarAsignatura(id, asignatura));
    }

    // Método para eliminar una asignatura (Solo ROL RECTOR)
    @PreAuthorize("hasRole('RECTOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAsignatura(@PathVariable Long id) {
        asignaturaService.eliminarAsignatura(id);
        return ResponseEntity.ok("Asignatura eliminada exitosamente");
    }

}
