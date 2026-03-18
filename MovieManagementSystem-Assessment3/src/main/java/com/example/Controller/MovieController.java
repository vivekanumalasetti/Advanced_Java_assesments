package com.example.Controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.model.Movie;
import com.example.Service.MovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String getAllMovies(Model model) {
        List<Movie> movieList = movieService.getAllMovies();
        model.addAttribute("movies", movieList);
        return "movie-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movie-form";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/edit/{id}")
    public String editMovie(@PathVariable Integer id, Model model) { 
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "movie-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Integer id) {  
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }
}