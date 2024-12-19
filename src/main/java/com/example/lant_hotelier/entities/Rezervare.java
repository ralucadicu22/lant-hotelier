package com.example.lant_hotelier.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tblRezervari")
public class Rezervare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short idRezervare;

    @Column(name = "id_Clienti")
    private Short idClienti;

    @Column(name = "id_Hotel")
    private Short idHotel;

    @Column(name = "idCamera")
    private Short idCamera;

    @Column(name = "check_inRezervare")
    private LocalDate checkInRezervare;

    @Column(name = "check_outRezervare")
    private LocalDate checkOutRezervare;


    public Short getIdClienti() {
        return idClienti;
    }

    public void setIdClienti(Short idClienti) {
        this.idClienti = idClienti;
    }

    public Short getIdRezervare() {
        return idRezervare;
    }

    public void setIdRezervare(Short idRezervare) {
        this.idRezervare = idRezervare;
    }

    public Short getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Short idHotel) {
        this.idHotel = idHotel;
    }

    public Short getIdCamera() {
        return idCamera;
    }

    public void setIdCamera(Short idCamera) {
        this.idCamera = idCamera;
    }

    public LocalDate getCheckInRezervare() {
        return checkInRezervare;
    }

    public void setCheckInRezervare(LocalDate checkInRezervare) {
        this.checkInRezervare = checkInRezervare;
    }

    public LocalDate getCheckOutRezervare() {
        return checkOutRezervare;
    }

    public void setCheckOutRezervare(LocalDate checkOutRezervare) {
        this.checkOutRezervare = checkOutRezervare;
    }
}