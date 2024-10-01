package com.example.demo.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

// lombok anotaciones
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
// data jpa anotaciones
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    private UUID id;

    @Column(nullable = false, length = 56)
    private String nombre;

    @Column(name = "nif", nullable = false, length = 16)
    private String numeroIdentificacion;
}
