package com.ms.historyinquiry.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String vaccineType;
    private String diseasePrevented;
    private int dosesAdministered;
    private Date vaccinationDate;

    public User(List<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }

    public List<Vaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Vaccine> vaccines;

    public User() {}

    public User(Long id, String name, int age, String vaccineType, String diseasePrevented, int dosesAdministered, Date vaccinationDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.vaccineType = vaccineType;
        this.diseasePrevented = diseasePrevented;
        this.dosesAdministered = dosesAdministered;
        this.vaccinationDate = vaccinationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }

    public String getDiseasePrevented() {
        return diseasePrevented;
    }

    public void setDiseasePrevented(String diseasePrevented) {
        this.diseasePrevented = diseasePrevented;
    }

    public int getDosesAdministered() {
        return dosesAdministered;
    }

    public void setDosesAdministered(int dosesAdministered) {
        this.dosesAdministered = dosesAdministered;
    }

    public Date getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(Date vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public String toCsv() {
        return String.format("%s,%d,%s,%s,%d,%s",
                name, age, vaccineType, diseasePrevented, dosesAdministered, vaccinationDate);
    }

}
