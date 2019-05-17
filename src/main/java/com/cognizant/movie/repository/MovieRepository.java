package com.cognizant.movie.repository;

import com.cognizant.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findMovieByTitle(String title);

    List<Movie> findMovieByYear(String year);

}
