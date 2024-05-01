package Immunization.Schedule.demo.microservicio.modelos;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class CalendarioVacunacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Usuario usuario;
    @OneToOne
    private VacunaDTO vacuna;

    public CalendarioVacunacion(Long id, Usuario usuario, VacunaDTO vacuna) {
        this.id = id;
        this.usuario = usuario;
        this.vacuna = vacuna;
    }

    public CalendarioVacunacion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public VacunaDTO getVacuna() {
        return vacuna;
    }

    public void setVacuna(VacunaDTO vacuna) {
        this.vacuna = vacuna;
    }
}