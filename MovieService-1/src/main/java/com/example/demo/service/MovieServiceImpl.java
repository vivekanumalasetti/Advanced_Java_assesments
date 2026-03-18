

package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.MovieMapper;
import com.example.demo.dto.MovieRequestDTO;
import com.example.demo.dto.MovieResponseDTO;
import com.example.demo.exception.MovieNotFoundException;
import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{
	
	private final MovieRepository movieRepository;
	
	private final MovieMapper mapper;

	public MovieServiceImpl(MovieRepository movieRepository, MovieMapper mapper) {
		this.movieRepository = movieRepository;
		this.mapper = mapper;
	}

	@Override
	public MovieResponseDTO createMovie(MovieRequestDTO dto) {
		Movie movie = mapper.toEntity(dto);
		return mapper.toDTO(movieRepository.save(movie));
	}

	@Override
	public List<MovieResponseDTO> getMovies() {
		List<Movie> movie = movieRepository.findAll();
		return movie.stream().map(mapper::toDTO).toList();
	}

	@Override
	public MovieResponseDTO getById(Long id) {
		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new MovieNotFoundException("Movie not Found with the ID" + id));
		return mapper.toDTO(movie);
	}
	
	
}
