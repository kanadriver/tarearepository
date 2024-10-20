package com.codigo.persistencia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "persona")
@Getter
@Setter
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("nombres")
    @Column(name = "nombres", length = 100, nullable = false)
    private String nombres;

    @JsonProperty("apellidos")
    @Column(name = "apellidos", length = 100, nullable = false)
    private String apellidos;

    @JsonProperty("num_documento")
    @Column(name = "num_documento", length = 20, nullable = false, unique = true)
    private String numDocumento;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoPersona estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private DireccionEntity direccion;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<PedidoEntity> pedidos;

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
