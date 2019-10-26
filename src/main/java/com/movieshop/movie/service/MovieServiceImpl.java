package com.movieshop.movie.service;

import com.movieshop.movie.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {

    private Map<Integer,Movie> allMovies;
    private Map<Integer,Movie> rentedMovies;

    public MovieServiceImpl(){
        loadMovies();
    }

    @Override
    public List<Movie> listAllMovies() {
        return new ArrayList<>(allMovies.values());
    }

    @Override
    public List<Movie> listAllRentedMovies() {
        return new ArrayList<>(rentedMovies.values());
    }

    @Override
    public Movie getByIdAll(Integer id) {
        return allMovies.get(id);
    }

    @Override
    public Movie saveOrUpdateAll(Movie movie) {
        if(movie!=null){
            if(movie.getId()==null){
                movie.setId(genNextKey());
            }
            allMovies.put(movie.getId(),movie);
            return  movie;
        }else{
            throw new RuntimeException("Not allowed null.");
        }
    }

    @Override
    public void deleteAll(Integer id) {
        allMovies.remove(id);
    }

    @Override
    public Movie getByIdRent(Integer id) {
        return rentedMovies.get(id);
    }

    @Override
    public Movie saveOrUpdateRent(Movie movie) {
        if(movie!=null){
            if(movie.getId()==null){
                movie.setId(genNextKey());
            }
            rentedMovies.put(movie.getId(),movie);
            return  movie;
        }else{
            throw new RuntimeException("Not allowed null.");
        }
    }

    @Override
    public void deleteRent(Integer id) {
        rentedMovies.remove(id);
    }

    private Integer genNextKey(){
        if(!allMovies.keySet().isEmpty()){
            return Collections.max(allMovies.keySet())+1;
        }else {
            return 1;
        }
    }

    public void loadMovies(){
        allMovies=new HashMap<>();
        Movie movie=new Movie();
        movie.setId(1);
        movie.setPrice("12");
        movie.setAgeRestriction("18");
        movie.setDirector("Kek");
        movie.setGenre("Kek1");
        movie.setName("abcd");
        movie.setBudget(120000);
        movie.setYearOfRelease(1998);
        allMovies.put(1,movie);
        rentedMovies=new HashMap<>();
    }
}
