package com.codigo.persistencia.repository;

import com.codigo.persistencia.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {

    List<PersonaEntity> findAllByEstado(String estado);

    Optional<PersonaEntity> findByNumDocumento(String numDocumento);

    @Query("SELECT p FROM PersonaEntity p WHERE p.estado = :estado")
    List<PersonaEntity> findByEstadoQuery(@Param("estado") String estado);
}
