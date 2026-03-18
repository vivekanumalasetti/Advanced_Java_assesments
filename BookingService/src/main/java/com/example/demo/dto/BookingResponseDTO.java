package com.example.demo.dto;

public class BookingResponseDTO {

    private Long bookingId;
    private Long movieId;
    private Integer tickets;
    private Double totalAmount;

    public BookingResponseDTO(Long bookingId, Long movieId, Integer tickets, Double totalAmount) {
        this.bookingId = bookingId;
        this.movieId = movieId;
        this.tickets = tickets;
        this.totalAmount = totalAmount;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public Integer getTickets() {
        return tickets;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }
}