package com.codigo.persistencia.service.impl;

import com.codigo.persistencia.entity.EstadoPersona;
import com.codigo.persistencia.entity.PersonaEntity;
import com.codigo.persistencia.repository.PersonaRepository;
import com.codigo.persistencia.service.PersonaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public PersonaEntity crearPersona(PersonaEntity persona) {
        return personaRepository.save(persona);
    }

    @Override
    public List<PersonaEntity> buscarTodos() {
        return personaRepository.findAll();
    }

    @Override
    public Optional<PersonaEntity> buscarPersonaPorDocumento(String numDocumento) {
        return personaRepository.findByNumDocumento(numDocumento);
    }

    @Override
    public PersonaEntity actualizarPersona(PersonaEntity persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void eliminarPersona(Long id) {
        Optional<PersonaEntity> persona = personaRepository.findById(id);
        persona.ifPresent(p -> {
            p.setEstado(EstadoPersona.INACTIVO);  // Eliminación lógica
            personaRepository.save(p);
        });
    }
}
