package com.example.demo.servicio;

import com.example.demo.entidad.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioServicio {
    List<Usuario> encontrarTodosLosUsuarios();

    Optional<Usuario> encontrarUsuarioPorId(UUID usuarioId);

    Usuario registrarNuevoUsuario(Usuario usuario);

    Usuario modificarUsuario(Usuario usuario);

    void eliminarUsuarioConId(UUID usuarioId);
}
