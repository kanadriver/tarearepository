package com.codigo.persistencia.controller;

import com.codigo.persistencia.entity.DireccionEntity;
import com.codigo.persistencia.service.DireccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/direcciones/v1")
public class DireccionController {

    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @PostMapping("/crearDireccion")
    public ResponseEntity<DireccionEntity> crearDireccion(@RequestBody DireccionEntity direccion) {
        DireccionEntity nuevaDireccion = direccionService.crearDireccion(direccion);
        return ResponseEntity.status(201).body(nuevaDireccion);
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<DireccionEntity>> buscarTodos() {
        return ResponseEntity.ok(direccionService.buscarTodos());
    }

    @GetMapping("/buscarDireccion/{id}")
    public ResponseEntity<DireccionEntity> buscarPorId(@PathVariable Long id) {
        Optional<DireccionEntity> direccion = direccionService.buscarPorId(id);
        return direccion.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/actualizarDireccion")
    public ResponseEntity<DireccionEntity> actualizarDireccion(@RequestBody DireccionEntity direccion) {
        DireccionEntity direccionActualizada = direccionService.actualizarDireccion(direccion);
        return ResponseEntity.ok(direccionActualizada);
    }

    @DeleteMapping("/eliminarDireccion/{id}")
    public ResponseEntity<Void> eliminarDireccion(@PathVariable Long id) {
        direccionService.eliminarDireccion(id);
        return ResponseEntity.status(204).build();
    }
}
