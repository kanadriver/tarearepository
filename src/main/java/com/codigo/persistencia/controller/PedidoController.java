package com.codigo.persistencia.controller;

import com.codigo.persistencia.entity.PedidoEntity;
import com.codigo.persistencia.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos/v1")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/crearPedido")
    public ResponseEntity<PedidoEntity> crearPedido(@RequestBody PedidoEntity pedido) {
        PedidoEntity nuevoPedido = pedidoService.crearPedido(pedido);
        return ResponseEntity.status(201).body(nuevoPedido);
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<PedidoEntity>> buscarTodos() {
        return ResponseEntity.ok(pedidoService.buscarTodos());
    }

    @GetMapping("/buscarPedidoPorEstado")
    public ResponseEntity<List<PedidoEntity>> buscarPorEstado(@RequestParam String estado) {
        List<PedidoEntity> pedidos = pedidoService.buscarPorEstado(estado);
        return ResponseEntity.ok(pedidos);
    }

    @PutMapping("/actualizarPedido")
    public ResponseEntity<PedidoEntity> actualizarPedido(@RequestBody PedidoEntity pedido) {
        PedidoEntity pedidoActualizado = pedidoService.actualizarPedido(pedido);
        return ResponseEntity.ok(pedidoActualizado);
    }

    @DeleteMapping("/eliminarPedido/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
        return ResponseEntity.status(204).build();
    }
}
