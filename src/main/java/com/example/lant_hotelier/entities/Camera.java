package com.example.lant_hotelier.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tblCamere")
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short idCamera;

    @Column(name = "id_Hotel")
    private Short idHotel;

    private BigDecimal pretNoapteCamera;
    private Short capacitateCamera;
    private String disponibilitateCamera;

    public Short getIdCamera() {
        return idCamera;
    }

    public void setIdCamera(Short idCamera) {
        this.idCamera = idCamera;
    }

    public Short getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Short idHotel) {
        this.idHotel = idHotel;
    }

    public BigDecimal getPretNoapteCamera() {
        return pretNoapteCamera;
    }

    public void setPretNoapteCamera(BigDecimal pretNoapteCamera) {
        this.pretNoapteCamera = pretNoapteCamera;
    }

    public Short getCapacitateCamera() {
        return capacitateCamera;
    }

    public void setCapacitateCamera(Short capacitateCamera) {
        this.capacitateCamera = capacitateCamera;
    }

    public String getDisponibilitateCamera() {
        return disponibilitateCamera;
    }

    public void setDisponibilitateCamera(String disponibilitateCamera) {
        this.disponibilitateCamera = disponibilitateCamera;
    }
}