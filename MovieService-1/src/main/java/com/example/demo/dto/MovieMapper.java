package com.example.demo.dto;

import org.springframework.stereotype.Component;

import com.example.demo.model.Movie;

@Component
public class MovieMapper {
	
	public Movie toEntity(MovieRequestDTO dto) {
		Movie movie = new Movie(null, null, null, null);
		movie.setName(dto.getName());
		movie.setLanguage(dto.getLanguage());
		movie.setPrice(dto.getPrice());
		return movie;
	}
	
	public MovieResponseDTO toDTO(Movie movie) {
		return new MovieResponseDTO(movie.getId(), movie.getName(), movie.getLanguage(), movie.getPrice());
	}
}