package com.example.movie;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
public class MovieController {

    private final MovieService service;

    @Autowired
    public MovieController(MovieService service) {  // Constructor injection
        this.service = service;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return service.getMovies();
    }
}
