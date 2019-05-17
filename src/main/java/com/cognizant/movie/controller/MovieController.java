package com.cognizant.movie.controller;

import com.cognizant.movie.model.Movie;
import com.cognizant.movie.repository.MovieRepository;
import com.cognizant.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MovieController {

    private  MovieService movieService;

    @Autowired
    MovieRepository movieRepository;


    @GetMapping("/allmovies")
    public List<Movie> getMovies() {
        return movieRepository.findAll();

    }

    @GetMapping("/movie/title")
    public List<Movie> getMoviebyTitle(@RequestParam String title) {
        return movieRepository.findMovieByTitle(title);

    }


    @GetMapping("/movie/year")
    public List<Movie> getMovieByYear(@RequestParam String year) {
        return movieRepository.findMovieByYear(year);

    }

    @PostMapping("/movie")
    public ResponseEntity<String> createMovie(@RequestBody Movie movie) {
        Movie newMovie = movieService.addMoview(movie);

        if(newMovie == null) {
            return new ResponseEntity<>("Movie already exists!!", HttpStatus.ALREADY_REPORTED);
        }
        return new ResponseEntity<>("Movie added!!", HttpStatus.CREATED);
    }

}
