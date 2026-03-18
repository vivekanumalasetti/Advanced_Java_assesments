package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MovieRequestDTO;
import com.example.demo.dto.MovieResponseDTO;

public interface MovieService {
	
	MovieResponseDTO createMovie(MovieRequestDTO dto);
	
	List<MovieResponseDTO> getMovies();
	
	MovieResponseDTO getById(Long id);
}
