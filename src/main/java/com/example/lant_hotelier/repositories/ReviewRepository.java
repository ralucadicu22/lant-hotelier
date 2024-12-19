package com.example.lant_hotelier.repositories;


import com.example.lant_hotelier.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ReviewRepository extends JpaRepository<Hotel, Short> {

    @Transactional
    @Modifying
    @Query("UPDATE Hotel h SET h.recenziiHotel = :average WHERE h.idHotel = :idHotel")
    void updateAverageRating(@Param("idHotel") Short idHotel, @Param("average") Double average);
}