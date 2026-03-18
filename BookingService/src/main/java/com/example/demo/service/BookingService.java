package com.example.demo.service;


import java.util.List;

import com.example.demo.dto.BookingRequestDTO;
import com.example.demo.dto.BookingResponseDTO;

public interface BookingService {

    BookingResponseDTO createBooking(BookingRequestDTO dto);

    List<BookingResponseDTO> getBookings();
}
