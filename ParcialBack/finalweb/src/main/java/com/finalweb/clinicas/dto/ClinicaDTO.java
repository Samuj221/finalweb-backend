package com.finalweb.clinicas.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class ClinicaDTO {

    private Long identificador; // mapea al id

    @NotBlank @Size(min=2, max=120)
    private String nombre;

    @NotBlank @Size(min=4, max=200)
    private String direccion;

    @NotNull @Min(0)
    private Integer cantidadCamas;

    @NotBlank
    private String telefono;

    @NotBlank
    private String ciudad;

    @NotNull
    private LocalDate fechaCreacion;
}
