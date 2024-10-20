package com.codigo.persistencia.service;

import com.codigo.persistencia.entity.DireccionEntity;

import java.util.List;
import java.util.Optional;

public interface DireccionService {

    DireccionEntity crearDireccion(DireccionEntity direccion);

    Optional<DireccionEntity> buscarPorId(Long id);

    List<DireccionEntity> buscarTodos();

    DireccionEntity actualizarDireccion(DireccionEntity direccion);

    void eliminarDireccion(Long id);
}
