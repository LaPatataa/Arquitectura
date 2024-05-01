package com.ms.historyinquiry.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity(name = "Vaccine")
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String manufacturer;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vaccine(User user) {
        this.user = user;
    }

    private int dosesAdministered;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Vaccine() {}
    public String toString() {
        return "Vaccine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", dosesAdministered=" + dosesAdministered +
                '}';
    }

    public Vaccine(Long id, String name, String manufacturer, int dosesAdministered) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.dosesAdministered = dosesAdministered;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getDosesAdministered() {
        return dosesAdministered;
    }

    public void setDosesAdministered(int dosesAdministered) {
        this.dosesAdministered = dosesAdministered;
    }

    public String toCsv() {
        return String.format("%d,%s,%s,%d", id, name, manufacturer, dosesAdministered);
    }
}
