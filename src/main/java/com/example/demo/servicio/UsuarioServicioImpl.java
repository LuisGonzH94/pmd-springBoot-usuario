package com.example.demo.servicio;

import com.example.demo.entidad.Usuario;
import com.example.demo.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Slf4j
@RequiredArgsConstructor
@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Usuario> encontrarTodosLosUsuarios() {
        log.info("Consulta por todos los usuarios");
        return StreamSupport
                .stream(usuarioRepositorio.findAll().spliterator(), true)
                .toList();
    }

    @Override
    public Optional<Usuario> encontrarUsuarioPorId(UUID usuarioId) {
        log.info("Consulta de usuario por id: {}", usuarioId);
        return usuarioRepositorio.findById(usuarioId);
    }

    @Override
    public Usuario registrarNuevoUsuario(Usuario usuario) {
        log.info("Registra un nuevo Usuario: {}", usuario.toString());
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario modificarUsuario(Usuario usuario) {
        log.info("Modifica un usuario existente: {}", usuario.toString());
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public void eliminarUsuarioConId(UUID usuarioId) {
        log.info("Elimina un usuario por id: {}", usuarioId);
        usuarioRepositorio.deleteById(usuarioId);
    }
}
