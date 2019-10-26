package com.movieshop.movie.service;

import com.movieshop.movie.domain.Movie;
import org.springframework.ui.Model;

import java.util.List;

public interface MovieService {

    List<Movie> listAllMovies();
    List<Movie> listAllRentedMovies();

    Movie getByIdAll(Integer id);
    Movie getByIdRent(Integer id);
    Movie saveOrUpdateAll(Movie movie);
    Movie saveOrUpdateRent(Movie movie);
    void deleteAll(Integer id);
    void deleteRent(Integer id);
}
