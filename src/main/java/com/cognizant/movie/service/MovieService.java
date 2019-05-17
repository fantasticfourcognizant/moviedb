package com.cognizant.movie.service;

import com.cognizant.movie.model.Movie;
import com.cognizant.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMoview(Movie movie) {
        List<Movie> movies = movieRepository.findAll();

        for (Movie movie1 : movies) {
            if(movie1.getTitle().equals(movie.getTitle())) { return null; }
        }

        movieRepository.save(movie);
        return movie;
    }
}
