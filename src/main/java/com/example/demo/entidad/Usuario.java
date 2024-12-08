package com.example.demo.entidad;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

// lombok anotaciones
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
// data jpa anotaciones
@Entity
@Table(name = "usuarios")
@NamedQuery(name = "Usuario.findByNif", query = "from Usuario u where u.numeroIdentificacion = :numeroIdentificacion")
@NamedQuery(name = "Usuario.isARegistredNif", query = "select case when count(u)> 0 then true else false end from Usuario u where u.numeroIdentificacion = ?1")
public class Usuario {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 56)
    private String nombre;

    @Column(name = "nif", nullable = false, length = 16)
    private String numeroIdentificacion;
}
