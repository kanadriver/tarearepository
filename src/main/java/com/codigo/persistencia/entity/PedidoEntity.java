package com.codigo.persistencia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

@Entity
@Table(name = "pedido")
@Getter
@Setter
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("descripcion")
    @Column(name = "descripcion", length = 255, nullable = false)
    private String descripcion;

    @JsonProperty("cantidad")
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoPedido estado;

    @ManyToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private PersonaEntity persona;

    @Column(name = "created_by", nullable = false)
    private String created_by;

    @Column(name = "created_date", nullable = false)
    private Timestamp created_date;

    @Column(name = "update_by")
    private String update_by;

    @Column(name = "update_date")
    private Timestamp update_date;

    @Column(name = "delete_by")
    private String delete_by;

    @Column(name = "delete_date")
    private Timestamp delete_date;
}
