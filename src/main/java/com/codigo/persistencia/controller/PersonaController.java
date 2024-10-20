package com.codigo.persistencia.controller;

import com.codigo.persistencia.entity.PersonaEntity;
import com.codigo.persistencia.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas/v1")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping("/crearPersona")
    public ResponseEntity<PersonaEntity> crearPersona(@RequestBody PersonaEntity persona) {
        PersonaEntity nuevaPersona = personaService.crearPersona(persona);
        return ResponseEntity.status(201).body(nuevaPersona);
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<PersonaEntity>> buscarTodos() {
        return ResponseEntity.ok(personaService.buscarTodos());
    }

    @GetMapping("/buscarPersona/{numDocumento}")
    public ResponseEntity<PersonaEntity> buscarPersonaPorDocumento(@PathVariable String numDocumento) {
        Optional<PersonaEntity> persona = personaService.buscarPersonaPorDocumento(numDocumento);
        return persona.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/actualizarPersona")
    public ResponseEntity<PersonaEntity> actualizarPersona(@RequestBody PersonaEntity persona) {
        PersonaEntity personaActualizada = personaService.actualizarPersona(persona);
        return ResponseEntity.ok(personaActualizada);
    }

    @DeleteMapping("/eliminarPersona/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Long id) {
        personaService.eliminarPersona(id);
        return ResponseEntity.status(204).build();
    }
}
