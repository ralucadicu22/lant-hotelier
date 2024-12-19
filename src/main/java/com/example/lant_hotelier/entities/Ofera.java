package com.example.lant_hotelier.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Ofera")
public class Ofera {

    @EmbeddedId
    private OferaId id; // Clasă pentru cheia compusă

    @ManyToOne
    @MapsId("idHotel") // Mapare pentru id_hotel
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    @ManyToOne
    @MapsId("idFacilitate") // Mapare pentru id_facilitate
    @JoinColumn(name = "id_facilitate")
    private Facilitate facilitate;

    // Getteri și setteri
    public OferaId getId() {
        return id;
    }

    public void setId(OferaId id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Facilitate getFacilitate() {
        return facilitate;
    }

    public void setFacilitate(Facilitate facilitate) {
        this.facilitate = facilitate;
    }
}
