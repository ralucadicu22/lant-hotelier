package com.example.lant_hotelier.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tblImages")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short idImage;

    private Integer idHotel;
    private String imageUrl;

    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public Short getIdImage() {
        return idImage;
    }

    public void setIdImage(Short idImage) {
        this.idImage = idImage;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}