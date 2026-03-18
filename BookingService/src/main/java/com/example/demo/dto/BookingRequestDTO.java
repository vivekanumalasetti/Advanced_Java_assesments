package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

public class BookingRequestDTO {

    @NotNull
    private Long movieId;

    @NotNull
    private Integer tickets;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Integer getTickets() {
        return tickets;
    }

    public void setTickets(Integer tickets) {
        this.tickets = tickets;
    }
}