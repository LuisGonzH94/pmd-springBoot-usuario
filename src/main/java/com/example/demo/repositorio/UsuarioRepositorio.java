package com.example.demo.repositorio;

import com.example.demo.entidad.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, UUID> {

    Optional<Usuario> findByNif(@Param("numeroIdentificacion") String numeroIdenficacion);

    boolean isARegistredNif(String numeroIdentificacion);
}
