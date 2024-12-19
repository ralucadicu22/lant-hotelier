package com.example.lant_hotelier.entities;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "tblHotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short idHotel;

    private String numeHotel;
    private String adresaHotel;
    private String telefonHotel;
    private BigDecimal recenziiHotel;
    private String image;
    private String description;

    public String getNumeHotel() {
        return numeHotel;
    }

    public void setNumeHotel(String numeHotel) {
        this.numeHotel = numeHotel;
    }

    public String getAdresaHotel() {
        return adresaHotel;
    }

    public void setAdresaHotel(String adresaHotel) {
        this.adresaHotel = adresaHotel;
    }

    public String getTelefonHotel() {
        return telefonHotel;
    }

    public void setTelefonHotel(String telefonHotel) {
        this.telefonHotel = telefonHotel;
    }

    public BigDecimal getRecenziiHotel() {
        return recenziiHotel;
    }

    public void setRecenziiHotel(BigDecimal recenziiHotel) {
        this.recenziiHotel = recenziiHotel;
    }

    public Short getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Short idHotel) {
        this.idHotel = idHotel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    @OneToMany(mappedBy = "hotel")
    private List<Ofera> oferte;

    // Getteri și setteri
    public List<Ofera> getOferte() {
        return oferte;
    }

    public void setOferte(List<Ofera> oferte) {
        this.oferte = oferte;
    }
}

