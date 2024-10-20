package com.codigo.persistencia.service.impl;

import com.codigo.persistencia.entity.EstadoPedido;
import com.codigo.persistencia.entity.PedidoEntity;
import com.codigo.persistencia.repository.PedidoRepository;
import com.codigo.persistencia.service.PedidoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public PedidoEntity crearPedido(PedidoEntity pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<PedidoEntity> buscarTodos() {
        return pedidoRepository.findAll();
    }

    @Override
    public List<PedidoEntity> buscarPorEstado(String estado) {
        return pedidoRepository.findByEstadoQuery(estado);
    }

    @Override
    public PedidoEntity actualizarPedido(PedidoEntity pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void eliminarPedido(Long id) {
        pedidoRepository.findById(id).ifPresent(p -> {
            p.setEstado(EstadoPedido.ELIMINADO);  // Eliminación lógica
            pedidoRepository.save(p);
        });
    }
}
