package com.example.demo.dto;

import org.springframework.stereotype.Component;

import com.example.demo.model.Booking;

@Component
public class BookingMapper {

    public Booking toEntity(BookingRequestDTO dto) {

        Booking booking = new Booking();
        booking.setMovieId(dto.getMovieId());
        booking.setTickets(dto.getTickets());

        return booking;
    }

    public BookingResponseDTO toDTO(Booking booking) {

        return new BookingResponseDTO(
                booking.getBookingId(),
                booking.getMovieId(),
                booking.getTickets(),
                booking.getTotalAmount()
        );
    }
}