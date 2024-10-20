package com.codigo.persistencia.service;

import com.codigo.persistencia.entity.PedidoEntity;

import java.util.List;

public interface PedidoService {

    PedidoEntity crearPedido(PedidoEntity pedido);

    List<PedidoEntity> buscarTodos();

    List<PedidoEntity> buscarPorEstado(String estado);

    PedidoEntity actualizarPedido(PedidoEntity pedido);

    void eliminarPedido(Long id);
}
