package com.example.lant_hotelier.entities;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tblFacilitati")
public class Facilitate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short idFacilitate;

    private String numeFacilitate;

    private String descriereFacilitate;

    private Double pretFacilitate;

    public Short getIdFacilitate() {
        return idFacilitate;
    }

    public void setIdFacilitate(Short idFacilitate) {
        this.idFacilitate = idFacilitate;
    }

    public String getNumeFacilitate() {
        return numeFacilitate;
    }

    public void setNumeFacilitate(String numeFacilitate) {
        this.numeFacilitate = numeFacilitate;
    }

    public String getDescriereFacilitate() {
        return descriereFacilitate;
    }

    public void setDescriereFacilitate(String descriereFacilitate) {
        this.descriereFacilitate = descriereFacilitate;
    }

    public Double getPretFacilitate() {
        return pretFacilitate;
    }

    public void setPretFacilitate(Double pretFacilitate) {
        this.pretFacilitate = pretFacilitate;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facilitate that = (Facilitate) o;
        return Objects.equals(numeFacilitate, that.numeFacilitate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeFacilitate);
    }
    @OneToMany(mappedBy = "facilitate")
    private List<Ofera> oferte;

    // Getteri și setteri
    public List<Ofera> getOferte() {
        return oferte;
    }

    public void setOferte(List<Ofera> oferte) {
        this.oferte = oferte;
    }
}
