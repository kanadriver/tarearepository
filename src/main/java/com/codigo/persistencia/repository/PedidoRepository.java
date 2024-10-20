package com.codigo.persistencia.repository;

import com.codigo.persistencia.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    List<PedidoEntity> findAllByEstado(String estado);

    @Query("SELECT p FROM PedidoEntity p WHERE p.estado = :estado")
    List<PedidoEntity> findByEstadoQuery(@Param("estado") String estado);
}
