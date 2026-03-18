package com.example.demo.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.BookingRequestDTO;
import com.example.demo.dto.BookingResponseDTO;
import com.example.demo.service.BookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingResponseDTO> createBooking(
            @Valid @RequestBody BookingRequestDTO dto) {

        return ResponseEntity.ok(bookingService.createBooking(dto));
    }

    @GetMapping
    public ResponseEntity<List<BookingResponseDTO>> getBookings() {

        return ResponseEntity.ok(bookingService.getBookings());
    }
}