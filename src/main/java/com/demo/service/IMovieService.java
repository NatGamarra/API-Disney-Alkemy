package com.demo.service;

import com.demo.dto.MovieDTO;
import com.demo.entities.Movie;

import java.util.List;

public interface IMovieService {


    public void saveMovie(Movie movie);
    public List<MovieDTO> getMovies();

    public List<Movie> findAllMovies();

    public Movie findMovie(Long id);

    public void deleteMovie(Long id);

    public void editMovie(Movie movie);

    public List<Movie> findByIdGenre(int idGenre);

    public List<Movie> findByName(String name);

    public List<Movie> orderByCreationDate(String order);


}
