package com.codigo.persistencia.service;

import com.codigo.persistencia.entity.PersonaEntity;

import java.util.List;
import java.util.Optional;

public interface PersonaService {

    PersonaEntity crearPersona(PersonaEntity persona);

    List<PersonaEntity> buscarTodos();

    Optional<PersonaEntity> buscarPersonaPorDocumento(String numDocumento);

    PersonaEntity actualizarPersona(PersonaEntity persona);

    void eliminarPersona(Long id);
}
