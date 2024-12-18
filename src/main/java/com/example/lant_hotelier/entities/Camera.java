package com.example.lant_hotelier.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tblCamere")
public class Camera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCamera;

    @ManyToOne
    @JoinColumn(name = "id_Hotel", nullable = false)
    private Hotel hotel;

    private BigDecimal pretNoapteCamera;
    private int capacitateCamera;
    private String disponibilitateCamera;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Long getIdCamera() {
        return idCamera;
    }

    public void setIdCamera(Long idCamera) {
        this.idCamera = idCamera;
    }

    public int getCapacitateCamera() {
        return capacitateCamera;
    }

    public void setCapacitateCamera(int capacitateCamera) {
        this.capacitateCamera = capacitateCamera;
    }

    public BigDecimal getPretNoapteCamera() {
        return pretNoapteCamera;
    }

    public void setPretNoapteCamera(BigDecimal pretNoapteCamera) {
        this.pretNoapteCamera = pretNoapteCamera;
    }

    public String getDisponibilitateCamera() {
        return disponibilitateCamera;
    }

    public void setDisponibilitateCamera(String disponibilitateCamera) {
        this.disponibilitateCamera = disponibilitateCamera;
    }
}

