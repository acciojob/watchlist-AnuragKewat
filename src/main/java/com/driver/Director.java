package com.driver;

public class Director {
    private String name;
    private int NoOfMovies;
    private double imdbRating;

    public Director(String name, int noOfMovies, double imdbRating) {
        this.name = name;
        NoOfMovies = noOfMovies;
        this.imdbRating = imdbRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfMovies() {
        return NoOfMovies;
    }

    public void setNoOfMovies(int noOfMovies) {
        NoOfMovies = noOfMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
