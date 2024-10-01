package com.example.demo.controlador;

import com.example.demo.servicio.UsuarioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;


}
