// Write your code here
package com.example.movie;

import com.example.movie.Movie;
import java.util.*;

public interface MovieRepository{
    List<Movie> getMovies();
    Movie addMovie(Movie movie);
    Movie getMovieById(int movieId);
}