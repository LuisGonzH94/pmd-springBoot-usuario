package com.example.demo.controlador;

import com.example.demo.entidad.Usuario;
import com.example.demo.modelo.ActualizaUsuarioDto;
import com.example.demo.modelo.NuevoUsuarioDto;
import com.example.demo.modelo.UsuarioDto;
import com.example.demo.servicio.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    @GetMapping({"", "/"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UsuarioDto[]> obtenerTodosLosUsuarios() {
        UsuarioDto[] usuarios = usuarioServicio.encontrarTodosLosUsuarios()
                .stream()
                .map(it -> UsuarioDto.nuevaInstanciaDesde(it))
                .toArray(UsuarioDto[]::new);

        return ResponseEntity.ofNullable(usuarios);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioDto> obtenerUsuarioPorUsuarioId(@PathVariable UUID usuarioId) {
        Optional<UsuarioDto> usuarioDto = usuarioServicio.encontrarUsuarioPorId(usuarioId)
                .map(UsuarioDto::nuevaInstanciaDesde);

        return ResponseEntity.of(usuarioDto);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioDto> crearUsuario(@RequestBody @Valid NuevoUsuarioDto usuarioDto) {
        Usuario usuario = usuarioServicio.registrarNuevoUsuario(usuarioDto.mapearAUsuario());

        URI location = URI.create("/api/"+usuario.getId());
        UsuarioDto response = UsuarioDto.nuevaInstanciaDesde(usuario);

        return ResponseEntity.created(location).body(response);
    }

    @PutMapping({"/{usuarioId}", "/{usuarioId}/"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<UsuarioDto> actualizarUsuario(@PathVariable UUID usuarioId,
                                                        @RequestBody @Valid ActualizaUsuarioDto usuarioDto) {
        Usuario usuario = usuarioServicio.modificarUsuario(usuarioDto.mapearAUsuario(usuarioId));
        UsuarioDto response = UsuarioDto.nuevaInstanciaDesde(usuario);

        return ResponseEntity.accepted().body(response);
    }

    @DeleteMapping({"/{usuarioId}", "/{usuarioId}/"})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Void> eliminarUsuarioPorUsuarioId(@PathVariable UUID usuarioId) {
        usuarioServicio.eliminarUsuarioConId(usuarioId);

        return ResponseEntity.ok().build();
    }

}
