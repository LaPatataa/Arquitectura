package Immunization.Schedule.demo.microservicio.servicios;

import Immunization.Schedule.demo.microservicio.modelos.CalendarioVacunacion;
import Immunization.Schedule.demo.microservicio.modelos.Usuario;
import Immunization.Schedule.demo.microservicio.modelos.VacunaDTO;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CalendarioVacunacionService {

    @Autowired
    private EmailService emailSender;
    @Autowired
    private VacunacionService vacunacionService;

    public void generarCalendarioVacunacion(Usuario usuario) throws MessagingException {

        CalendarioVacunacion calendarioVacunacion = new CalendarioVacunacion();
        calendarioVacunacion.setUsuario(usuario);
        List<VacunaDTO> vacunasRecomendadas = vacunacionService.obtenerVacunasRecomendadas(usuario.getEdad());

        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Hola ").append(usuario.getNombre()).append(", te informamos que las vacunas recomendadas con " + usuario.getEdad() + " meses son:\n");

        if(vacunasRecomendadas.isEmpty()){
            mensaje.append("Las edades despues de los 5 años");
        }else{
            for (VacunaDTO vacuna : vacunasRecomendadas) {
                mensaje.append("- ").append(vacuna.getNombre());
                mensaje.append("  ..... dosis : ").append(vacuna.getDosis());
                mensaje.append("  ..... a los " + vacuna.getMeses() + " meses").append("\n");
            }
            emailSender.sendEmail(usuario.getCorreo(), usuario.getNombre() + " - Alerta y notificación", mensaje.toString());
        }
    }
}