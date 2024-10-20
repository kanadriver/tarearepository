package com.codigo.persistencia.repository;

import com.codigo.persistencia.entity.DireccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepository extends JpaRepository<DireccionEntity, Long> {
    // No se añade por ser one to one con persona
}
