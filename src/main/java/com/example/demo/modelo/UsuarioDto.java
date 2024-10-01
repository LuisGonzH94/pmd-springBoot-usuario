package com.example.demo.modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class UsuarioDto {

    private UUID id;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 56)
    private String nombre;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 16)
    private String numeroIdentificacion;
}
