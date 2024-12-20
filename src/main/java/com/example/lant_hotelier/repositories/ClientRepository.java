package com.example.lant_hotelier.repositories;

import com.example.lant_hotelier.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Short> {

}