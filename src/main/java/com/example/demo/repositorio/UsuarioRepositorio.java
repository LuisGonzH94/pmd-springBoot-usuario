package com.example.demo.repositorio;

import com.example.demo.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, UUID> {
}
