package com.codigo.persistencia.service.impl;

import com.codigo.persistencia.entity.DireccionEntity;
import com.codigo.persistencia.repository.DireccionRepository;
import com.codigo.persistencia.service.DireccionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionServiceImpl implements DireccionService {

    private final DireccionRepository direccionRepository;

    public DireccionServiceImpl(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    @Override
    public DireccionEntity crearDireccion(DireccionEntity direccion) {
        return direccionRepository.save(direccion);
    }

    @Override
    public Optional<DireccionEntity> buscarPorId(Long id) {
        return direccionRepository.findById(id);
    }

    @Override
    public List<DireccionEntity> buscarTodos() {
        return direccionRepository.findAll();
    }

    @Override
    public DireccionEntity actualizarDireccion(DireccionEntity direccion) {
        return direccionRepository.save(direccion);
    }

    @Override
    public void eliminarDireccion(Long id) {
        direccionRepository.deleteById(id);
    }
}
