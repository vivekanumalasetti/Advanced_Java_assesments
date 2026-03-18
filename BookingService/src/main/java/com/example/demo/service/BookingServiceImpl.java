package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.client.MovieClient;
import com.example.demo.dto.BookingMapper;
import com.example.demo.dto.BookingRequestDTO;
import com.example.demo.dto.BookingResponseDTO;
import com.example.demo.dto.MovieResponseDTO;
import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper mapper;
    private final MovieClient movieClient;

    public BookingServiceImpl(
            BookingRepository bookingRepository,
            BookingMapper mapper,
            MovieClient movieClient) {

        this.bookingRepository = bookingRepository;
        this.mapper = mapper;
        this.movieClient = movieClient;
    }

    @Override
    @CircuitBreaker(name = "movieService", fallbackMethod = "fallbackBooking")
    public BookingResponseDTO createBooking(BookingRequestDTO dto) {

        MovieResponseDTO movie = movieClient.getMovie(dto.getMovieId());

        Booking booking = mapper.toEntity(dto);

        double total = movie.getPrice() * dto.getTickets();

        booking.setTotalAmount(total);

        return mapper.toDTO(bookingRepository.save(booking));
    }

    public BookingResponseDTO fallbackBooking(BookingRequestDTO dto, Exception e) {

        Booking booking = mapper.toEntity(dto);
        booking.setTotalAmount(0.0);

        return mapper.toDTO(booking);
    }

    @Override
    public List<BookingResponseDTO> getBookings() {

        List<Booking> bookings = bookingRepository.findAll();

        return bookings.stream().map(mapper::toDTO).toList();
    }
}