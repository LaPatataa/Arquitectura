package com.ms.historyinquiry.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Vaccinedetails")
public class VaccineDetails {
    private String vaccineName;
    private String manufacturer;
    private int doseAdministered;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public VaccineDetails() {}

    public VaccineDetails(String vaccineName, String manufacturer, int doseAdministered) {
        this.vaccineName = vaccineName;
        this.manufacturer = manufacturer;
        this.doseAdministered = doseAdministered;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getDoseAdministered() {
        return doseAdministered;
    }

    public void setDoseAdministered(int doseAdministered) {
        this.doseAdministered = doseAdministered;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
