package com.example.demo.controlador;

import com.example.demo.PmdSpringbootUsuarioApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@SpringBootTest(webEnvironment = RANDOM_PORT, classes = PmdSpringbootUsuarioApplication.class)
class UsuarioControladorTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void cuandoObtenerTodosLosUsuarios_poseaAlMenosUno_entoncesDebeRetornarOK() {
        // construimos los datos para el escenario

        // ejecutamos la llamada al código a probar

        // validamos que los resultados sean los esperados
    }

    @Test
    void cuandoObtenerTodosLosUsuarios_noPoseaAlMenosUno_entoncesDebeRetornarNoContent() {
        // construimos los datos para el escenario

        // ejecutamos la llamada al código a probar

        // validamos que los resultados sean los esperados
    }

    @Test
    void cuandoObtenerUsuarioPorUsuarioId_seaDeUnUsuarioExistente_entoncesDebeRetornarOK() {
        // construimos los datos para el escenario

        // ejecutamos la llamada al código a probar

        // validamos que los resultados sean los esperados
    }

    @Test
    void cuandoObtenerUsuarioPorUsuarioId_noSeaDeUnUsuario_entoncesDebeRetornarNotFound() {
        // construimos los datos para el escenario

        // ejecutamos la llamada al código a probar

        // validamos que los resultados sean los esperados
    }
}