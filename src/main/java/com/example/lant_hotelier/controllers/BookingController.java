package com.example.lant_hotelier.controllers;

import com.example.lant_hotelier.entities.Camera;
import com.example.lant_hotelier.entities.Client;
import com.example.lant_hotelier.entities.Hotel;
import com.example.lant_hotelier.entities.Rezervare;
import com.example.lant_hotelier.repositories.BookingRepository;
import com.example.lant_hotelier.repositories.ClientRepository;
import com.example.lant_hotelier.repositories.RoomAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/book")
public class BookingController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomAvailabilityRepository roomAvailabilityRepository;

    @PostMapping
    public ResponseEntity<String> bookRoom(
            @RequestParam("id") Short id,
            @RequestParam("idCamera") Short idCamera,
            @RequestParam("numeClient") String numeClient,
            @RequestParam("prenumeClient") String prenumeClient,
            @RequestParam("telefonClienti") String telefonClienti,
            @RequestParam("emailClienti") String emailClienti,
            @RequestParam("checkInDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkInDate,
            @RequestParam("checkOutDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOutDate) {

        if (checkInDate.isBefore(LocalDate.now()) || checkOutDate.isBefore(checkInDate)) {
            return ResponseEntity.badRequest().body("Invalid check-in or check-out date.");
        }


        Client client = new Client();
        client.setNumeClient(numeClient);
        client.setPrenumeClient(prenumeClient);
        client.setTelefonClienti(telefonClienti);
        client.setEmailClienti(emailClienti);
        clientRepository.save(client);

        Rezervare rezervare = new Rezervare();
        rezervare.setIdHotel(id);
        rezervare.setIdClienti(client.getIdClienti());
        rezervare.setIdCamera(idCamera);
        rezervare.setCheckInRezervare(checkInDate);
        rezervare.setCheckOutRezervare(checkOutDate);
        bookingRepository.save(rezervare);

        Camera camera = roomAvailabilityRepository.findById(idCamera)
                .orElseThrow(() -> new IllegalArgumentException("Invalid room ID"));
        camera.setDisponibilitateCamera("Ocupat");
        roomAvailabilityRepository.save(camera);

        return ResponseEntity.ok("Booking successful!");
    }

    @DeleteMapping("/cancel")
    public ResponseEntity<String> cancelBooking(@RequestParam("reservationId") Short reservationId) {
        Rezervare rezervare = bookingRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found"));

        Camera camera = roomAvailabilityRepository.findById(rezervare.getIdCamera())
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));

        bookingRepository.delete(rezervare);

        camera.setDisponibilitateCamera("Disponibil");
        roomAvailabilityRepository.save(camera);

        return ResponseEntity.ok("Reservation canceled and room status updated to available.");
    }
}

