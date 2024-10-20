package com.codigo.persistencia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

@Entity
@Table(name = "direccion")
@Getter
@Setter
public class DireccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("avenida")
    @Column(name = "avenida", length = 100, nullable = false)
    private String avenida;

    @JsonProperty("numero")
    @Column(name = "numero", nullable = false)
    private String numero;

    @JsonProperty("distrito")
    @Column(name = "distrito", length = 100, nullable = false)
    private String distrito;

    @JsonProperty("provincia")
    @Column(name = "provincia", length = 100, nullable = false)
    private String provincia;

    @JsonProperty("departamento")
    @Column(name = "departamento", length = 100, nullable = false)
    private String departamento;

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
