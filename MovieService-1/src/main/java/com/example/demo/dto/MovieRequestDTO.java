package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequestDTO {
	
	@NotBlank(message = "Movie name is required")
	private String name;
	
	@NotBlank(message = "Movie Language is required")
	private String language;
	
	@NotNull(message = "Movie Price is required")
	private Double price;
}
