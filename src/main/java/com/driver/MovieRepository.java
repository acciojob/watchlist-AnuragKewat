package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    private Map<String, Movie> movieMap;
    private Map<String, Director> directorMap;
    private Map<String, List<String>> directorMovieMap;

    public MovieRepository() {
        movieMap = new HashMap<>();
        directorMap = new HashMap<>();
        directorMovieMap = new HashMap<>();
    }
    public void saveMovie(Movie movie) {
        movieMap.put(movie.getName(), movie);
    }
    public void saveDirector(Director director) {
        directorMap.put(director.getName(), director);
    }
    public void saveMovieDirectorPair(String movie, String director) {
        if(movieMap.containsKey(movie) && directorMap.containsKey(director)) {
            List<String> currentMovie = new ArrayList<>();
            if(directorMovieMap.containsKey(director)) currentMovie = directorMovieMap.get(director);

            currentMovie.add(movie);

            directorMovieMap.put(director, currentMovie);
        }
    }
    public Movie findMovie(String movie) {
        return movieMap.get(movie);
    }
    public Director findDirector(String director) {
        return directorMap.get(director);
    }
    public List<String> findMoviesFromDirector(String director) {
        List<String> movies = new ArrayList<>();
        if(directorMovieMap.containsKey(director)) return directorMovieMap.get(director);

        return movies;
    }
    public List<String> findAllMovies() {
        return new ArrayList<>(movieMap.keySet());
    }
    public void deleteDirector(String director) {
        List<String> movies = directorMovieMap.get(director);

        for(String movie: movies) {
            movieMap.remove(movie);
        }

        directorMap.remove(director);
        directorMovieMap.remove(director);
    }
    public void deleteAllDirector() {
        List<String> directors = new ArrayList<>(directorMovieMap.keySet());
        for(String director: directors) {
            deleteDirector(director);
        }
    }
}
