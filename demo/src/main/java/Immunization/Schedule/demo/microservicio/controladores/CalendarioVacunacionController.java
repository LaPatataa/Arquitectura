package Immunization.Schedule.demo.microservicio.controladores;

import Immunization.Schedule.demo.microservicio.servicios.CalendarioVacunacionService;
import Immunization.Schedule.demo.microservicio.modelos.CalendarioVacunacion;
import Immunization.Schedule.demo.microservicio.modelos.Usuario;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController

public class CalendarioVacunacionController {

    @Autowired
    private CalendarioVacunacionService calendarioVacunacionService;

    @PostMapping("/calendario-vacunacion")
    public ResponseEntity<?> generarCalendarioVacunacion(@RequestBody Usuario usuario) throws MessagingException {
        calendarioVacunacionService.generarCalendarioVacunacion(usuario);
        String mensaje = "Correo Enviado correctamente a " + usuario.getCorreo();
        return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("mensaje", mensaje));
    }
}