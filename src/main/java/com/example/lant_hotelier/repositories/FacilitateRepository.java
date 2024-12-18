package com.example.lant_hotelier.repositories;

import com.example.lant_hotelier.entities.Facilitate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilitateRepository extends JpaRepository<Facilitate, Long> {
}