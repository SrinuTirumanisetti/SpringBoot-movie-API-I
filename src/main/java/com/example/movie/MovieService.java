/*
 * You can use the following import statements
 * 
 * import org.springframework.web.server.ResponseStatusException;
 * import org.springframework.http.HttpStatus;
 * 
 */

package com.example.movie;

import com.example.movie.Movie;
import com.example.movie.MovieRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.*;
import org.springframework.stereotype.Service;

// Do not modify the below code

@Service
public class MovieService implements MovieRepository {

    private static HashMap<Integer, Movie> movieList = new HashMap<>();

    public MovieService() {
        movieList.put(1, new Movie(1, "Avengers: Endgame", "Robert Downey Jr."));
        movieList.put(2, new Movie(2, "Avatar", "Sam Worthington"));
        movieList.put(3, new Movie(3, "Titanic", "Leonardo DiCaprio"));
        movieList.put(4, new Movie(4, "Star Wars: The Force Awakens", "Daisy Ridley"));
        movieList.put(5, new Movie(5, "Jurassic World", "Chris Pratt"));
    }

    // Do not modify the above code

    // Write your code here
    int uniqueId = 6;

    @Override
    public List<Movie> getMovies(){
        Collection<Movie> movies = movieList.values();
        return new ArrayList<>(movies);
    }

    @Override
    public Movie addMovie(Movie movie){
        movie.setMovieId(uniqueId);
        movieList.put(uniqueId,movie);
        uniqueId=uniqueId+1;
        return movie;
    }

    @Override
    public Movie getMovieById(int movieId) {
        Movie movie = movieList.get(movieId);
        if (movie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found");
        }
        return movie;
    }

    @Override
    public Movie updateMovie(int movieId,Movie movie){
        Movie existingMovie = getMovieById(movieId);
        if(movie.getMovieName()!=null){
            existingMovie.setMovieName(movie.getMovieName());
        }
        if(movie.getLeadActor()!=null){
            existingMovie.setLeadActor(movie.getLeadActor());
        }
        return existingMovie;
    }
}
