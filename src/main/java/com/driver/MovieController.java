package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie) {
        movieService.addMovie(movie);

        return new ResponseEntity<>("Movie added successfully", HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director) {
        movieService.addDirector(director);
        return new ResponseEntity<>("Director added successfully", HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie, @RequestParam("director") String director) {
        movieService.addMovieDirectorPair(movie, director);
        return new ResponseEntity<>("Movie-Director Pair added successfully", HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name/{movie}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("movie") String movie) {
        Movie response = movieService.getMovie(movie);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
    @GetMapping("/get-director-by-name/{director}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("director") String director) {
        Director response = movieService.getDirector(director);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String director) {
        List<String> movies = movieService.getMoviesFromDirector(director);
        return new ResponseEntity<>(movies, HttpStatus.FOUND);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies() {
        List<String> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.FOUND);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam() String director) {
        movieService.deleteDirector(director);
        return new ResponseEntity<>("Director and its movies successfully deleted", HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors() {
        movieService.deleteAllDirector();
        return new ResponseEntity<>("All director and their movies deleted successfully", HttpStatus.ACCEPTED);
    }
}
