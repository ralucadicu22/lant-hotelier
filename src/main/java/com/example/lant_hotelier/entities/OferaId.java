package com.example.lant_hotelier.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OferaId implements Serializable {

    @Column(name = "id_hotel")
    private Short idHotel;

    @Column(name = "id_facilitate")
    private Short idFacilitate;

    // Getteri și setteri
    public Short getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Short idHotel) {
        this.idHotel = idHotel;
    }

    public Short getIdFacilitate() {
        return idFacilitate;
    }

    public void setIdFacilitate(Short idFacilitate) {
        this.idFacilitate = idFacilitate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OferaId oferaId = (OferaId) o;
        return Objects.equals(idHotel, oferaId.idHotel) &&
                Objects.equals(idFacilitate, oferaId.idFacilitate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHotel, idFacilitate);
    }
}
