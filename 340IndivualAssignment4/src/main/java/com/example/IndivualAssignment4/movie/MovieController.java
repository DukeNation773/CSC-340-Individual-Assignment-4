package com.example.IndivualAssignment4.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/all")
    public String getAllMovies(Model model) {
        model.addAttribute("movieList",
                movieService.getAllMovies());
        return "list-movie";
    }


    @GetMapping("/id={movieId}")
    public String getMovie(@PathVariable long movieId, Model model) {
        model.addAttribute("movie",
                movieService.getMovie(movieId));
        return "movie-detail";
    }

    @GetMapping("/delete/id={movieId}")
    public String deleteMovie(@PathVariable long movieId, Model model) {
        movieService.deleteMovie(movieId);
        return "redirect:/movie/all";
    }

    @PostMapping("/create")
    public String createMovie(Movie movie) {

        movieService.saveMovie(movie);
        return "redirect:/movie/all";
    }

    @PostMapping("/update")
    public String updateMovie(Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/movie/all";
    }

    @GetMapping("/new-movie")
    public String newMovieForm(Model model) {
        return "new-movie";
    }

    @GetMapping("/update/id={movieId}")
    public String updateMovieForm(@PathVariable long movieId, Model model) {
        model.addAttribute("movie",
                movieService.getMovie(movieId));
        return "update-movie";
    }
}
