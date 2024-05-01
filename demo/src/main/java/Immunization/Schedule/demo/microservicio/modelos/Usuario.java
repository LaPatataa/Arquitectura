package Immunization.Schedule.demo.microservicio.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
    @Entity
    public class Usuario {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nombre;
        private int edad;
        private String sexo;
        private String correo;

        public Usuario(Long id, String nombre, int edad, String sexo, String correo) {
            this.id = id;
            this.nombre = nombre;
            this.edad = edad;
            this.sexo = sexo;
            this.correo = correo;
        }

        public Usuario() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public String getSexo() {
            return sexo;
        }

        public void setSexo(String sexo) {
            this.sexo = sexo;
        }

        public String getCorreo(){return correo;}

        public void setCorreo(String correo){this.correo = correo;}
    }

