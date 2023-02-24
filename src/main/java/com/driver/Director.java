package com.driver;

public class Director {
    private String name;
    private int NumberOfMovies;
    private double imdbRating;

    public Director(String name, int noOfMovies, double imdbRating) {
        this.name = name;
        NumberOfMovies = noOfMovies;
        this.imdbRating = imdbRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfMovies() {
        return NumberOfMovies;
    }

    public void setNoOfMovies(int noOfMovies) {
        NumberOfMovies = noOfMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
