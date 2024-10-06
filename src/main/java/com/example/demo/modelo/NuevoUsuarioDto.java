package com.example.demo.modelo;

import com.example.demo.entidad.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class NuevoUsuarioDto {

    @NotNull
    @NotBlank
    @Size(min = 5, max = 56)
    private String nombre;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 16)
    private String numeroIdentificacion;

    public Usuario mapearAUsuario() {
        var usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setNumeroIdentificacion(numeroIdentificacion);

        return usuario;
    }
}
