package com.example.demo.servicio;

import com.example.demo.entidad.Usuario;
import com.example.demo.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Usuario> encontrarTodosLosUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Optional<Usuario> encontrarUsuarioPorId(UUID usuarioId) {
        return usuarioRepositorio.findById(usuarioId);
    }

    @Override
    public Usuario registrarNuevoUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario modificarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public void eliminarUsuarioConId(UUID usuarioId) {
        usuarioRepositorio.deleteById(usuarioId);
    }
}
