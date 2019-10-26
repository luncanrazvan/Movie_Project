package com.movieshop.movie.controller;

import com.movieshop.movie.domain.Movie;
import com.movieshop.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService){
        this.movieService=movieService;
    }

    @RequestMapping("/allMovies")
    public String listAllMovies(Model model){
        model.addAttribute("movies",movieService.listAllMovies());
        return "/allMovies";
    }

    @RequestMapping("/rentedMovies")
    public String listAllRentedMovies(Model model){
        model.addAttribute("rentedList",movieService.listAllRentedMovies());
        return "/rentedMovies";
    }

    @RequestMapping("/delete/{id}")
    public String deleteMovieByIdAll(@PathVariable Integer id){
        movieService.saveOrUpdateRent(movieService.getByIdAll(id));
        movieService.deleteAll(id);
        return "redirect:/allMovies";
    }

    @RequestMapping("/delete1/{id}")
    public String deleteMovieByIdRent(@PathVariable Integer id){
        movieService.saveOrUpdateAll(movieService.getByIdRent(id));
        movieService.deleteRent(id);
        return "redirect:/rentedMovies";
    }

    @RequestMapping("/showDetails/{id}")
    public String showMovieByIdAll(@PathVariable Integer id,Model model){
        model.addAttribute("movie",movieService.getByIdAll(id));
        return "/showDetails";
    }

    @RequestMapping(value = "/movieAE" ,method=RequestMethod.POST)
    public String updateOrSaveMovie(Movie movie){
        Movie savedMovie=movieService.saveOrUpdateAll(movie);
        return "redirect:/allMovies";
    }

    @RequestMapping("/edit/{id}")
    public String editMovie(@PathVariable Integer id,Model model){
        model.addAttribute("movie",movieService.getByIdAll(id));
        return "/editOrAdd";
    }

    @RequestMapping("/new")
    public String addNewMovie(Model model){
        model.addAttribute("movie",new Movie());
        return "/editOrAdd";
    }

    @RequestMapping("/remove/{id}")
    public String removeMoviePermanently(@PathVariable Integer id){
        movieService.deleteAll(id);
        return "redirect:/allMovies";
    }
}
