package Immunization.Schedule.demo.microservicio.servicios;

import Immunization.Schedule.demo.microservicio.modelos.VacunaDTO;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class VacunacionService {

    private final Map<Integer, List<VacunaDTO>> vacunasPorEdad;

    public VacunacionService() {
        this.vacunasPorEdad = new HashMap<>();
        configurarVacunasPorEdad();
    }

    private void configurarVacunasPorEdad() {
        List<VacunaDTO> vacunas0 = Arrays.asList(new VacunaDTO("Tuberculosis B.C.G", "Única",0), new VacunaDTO("Hepatitis B", "Recien Nacido",0));
        List<VacunaDTO> vacunas2 = Arrays.asList(new VacunaDTO("Pollo (Oral-IM)", "1ra",2)
                , new VacunaDTO("Pentavalente:Hepatitis b, Haemophilus influenzae Tipo B y Difeteria - Tosferia - Tetáno (DPT) ", "1ra",2)
                , new VacunaDTO("Rotavirus","1ra",2), new VacunaDTO("Neumococo","1ra",2));
        List<VacunaDTO> vacunas4 = Arrays.asList(new VacunaDTO("Pollo (Oral-IM)", "2ra",2)
                , new VacunaDTO("Pentavalente:Hepatitis b, Haemophilus influenzae Tipo B y Difeteria - Tosferia - Tetáno (DPT) ", "2ra",4)
                , new VacunaDTO("Rotavirus","2ra",4), new VacunaDTO("Neumococo","2ra",4));
        List<VacunaDTO> vacunas6 = Arrays.asList(new VacunaDTO("Pollo (Oral-IM)", "3ra",6)
                , new VacunaDTO("Pentavalente:Hepatitis b, Haemophilus influenzae Tipo B y Difeteria - Tosferia - Tetáno (DPT) ", "3ra",6)
                , new VacunaDTO("Influenza","1ra",6));
        List<VacunaDTO> vacunas7 = Arrays.asList(new VacunaDTO("Influenza","2ra",7));
        List<VacunaDTO> vacunas12 = Arrays.asList(new VacunaDTO("Sarampión Rubéola Paperas (SRP)", "1ra",12)
                , new VacunaDTO("Fiebre amarilla", "1ra",12), new VacunaDTO("Neumococo","Refuerzo",12)
                , new VacunaDTO("Influenza","Anual",12), new VacunaDTO("Hepatitis A","Única",12));
        List<VacunaDTO> vacunas18 = Arrays.asList(new VacunaDTO("Difteria - Tosferia Tétano (DPT)", "1er Refuerzo",18)
                , new VacunaDTO("Pollo (Oral - IM)", "1er Refuerzo",18));
        List<VacunaDTO> vacunas5anos = Arrays.asList(new VacunaDTO("Difteria - Tosferia Tétano (DPT)", "2do Refuerzo",60)
                , new VacunaDTO("Pollo (Oral - IM)", "2do Refuerzo",60), new VacunaDTO("Sarampión Rubéola Paperas (SRP)", "Refuerzo",60));

        vacunasPorEdad.put(0, vacunas0);
        vacunasPorEdad.put(2, vacunas2);
        vacunasPorEdad.put(6, vacunas6);
        vacunasPorEdad.put(7, vacunas7);
        vacunasPorEdad.put(12, vacunas12);
        vacunasPorEdad.put(18, vacunas18);
        vacunasPorEdad.put(60, vacunas5anos);
    }
    public List<VacunaDTO> obtenerVacunasRecomendadas(int edad) {
        List<VacunaDTO> vacunasRecomendadas = new ArrayList<>();

        for (int i = edad; i <= 60; i++) {
            List<VacunaDTO> vacunas = vacunasPorEdad.get(i);
            if (vacunas != null) {
                vacunasRecomendadas.addAll(vacunas);
                }
        }
        return vacunasRecomendadas;
    }
}