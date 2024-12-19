package com.example.lant_hotelier.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tblClienti")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short idClienti;
    @ManyToOne
    @JoinColumn(name = "id_Hotel")
    private Hotel hotel;
    private String numeClient;
    private String prenumeClient;
    private String telefonClienti;
    private String emailClienti;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Short getIdClienti() {
        return idClienti;
    }

    public void setIdClienti(Short idClienti) {
        this.idClienti = idClienti;
    }

    public String getNumeClient() {
        return numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    public String getPrenumeClient() {
        return prenumeClient;
    }

    public void setPrenumeClient(String prenumeClient) {
        this.prenumeClient = prenumeClient;
    }

    public String getTelefonClienti() {
        return telefonClienti;
    }

    public void setTelefonClienti(String telefonClienti) {
        this.telefonClienti = telefonClienti;
    }

    public String getEmailClienti() {
        return emailClienti;
    }

    public void setEmailClienti(String emailClienti) {
        this.emailClienti = emailClienti;
    }
}