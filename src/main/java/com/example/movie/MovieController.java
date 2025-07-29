package com.example.movie;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
public class MovieController {

    MovieService service = new MovieService();

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return service.getMovies();
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie){
        return service.addMovie(movie);
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable("movieId") int movieId){
        return service.getMovieById(movieId);
    }
    
    @PutMapping("/movies/{movieId}")
    public Movie updateMovie(@RequestBody Movie movie,@PathVariable("movieId") int movieId){
        return service.updateMovie(movieId,movie);
    }

    @DeleteMapping("/movies/{movieId}")
    public void deleteMovie(@PathVariable("movieId") int movieId){
        service.deleteMovie(movieId);
    }
}
