package com.finalweb.clinicas.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clinicas")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=120)
    private String nombre;

    @Column(nullable=false, length=200)
    private String direccion;

    @Column(name="cantidad_camas", nullable=false)
    private Integer cantidadCamas;

    @Column(length=40)
    private String telefono;

    @Column(length=80)
    private String ciudad;

    @Column(name="fecha_creacion")
    private LocalDate fechaCreacion;
}
