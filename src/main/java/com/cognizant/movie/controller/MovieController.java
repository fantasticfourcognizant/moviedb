package com.cognizant.movie.controller;

import com.cognizant.movie.model.Movie;
import com.cognizant.movie.repository.MovieRepository;
import com.cognizant.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Configuration
@EnableAutoConfiguration
@RestController
@EnableEurekaClient
public class MovieController {

    @Autowired
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

    @PostMapping("/addmovie")
    public ResponseEntity<String> createMovie(@RequestBody Movie movie) {
        Movie newMovie = movieService.addMoview(movie);
        System.out.println(newMovie);

        if(newMovie == null) {
            return new ResponseEntity<>("Movie already exists!!", HttpStatus.ALREADY_REPORTED);
        }
        return new ResponseEntity<>("Movie added!!", HttpStatus.CREATED);
    }

}
