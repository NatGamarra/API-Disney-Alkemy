package com.demo.service;
import com.demo.dto.MovieDTO;
import com.demo.entities.Movie;
import com.demo.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements IMovieService{

    @Autowired
    IMovieRepository iMovieRepository;

    @Override
    public List<MovieDTO> getMovies() {

        List<Movie> movies = iMovieRepository.findAll();

        List<MovieDTO> moviesDto = new ArrayList<MovieDTO>();

        MovieDTO moviedto = new MovieDTO();

        for (Movie movie : movies){
            moviedto.setImage(movie.getImage());
            moviedto.setTitle(movie.getTitle());
            moviedto.setCreationDate(movie.getCreationDate());

            moviesDto.add(moviedto);
            moviedto = new MovieDTO();
        }

        return moviesDto;
    }

    @Override
    public void saveMovie(Movie movie) {
        iMovieRepository.save(movie);
    }


    @Override
    public Movie findMovie(Long id) {
        return iMovieRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteMovie(Long id) {
        iMovieRepository.deleteById(id);
    }

    @Override
    public void editMovie(Movie movie) {
        this.saveMovie(movie);
    }


    @Override
    public List<Movie> findByIdGenre(int idGenre) {
        return iMovieRepository.findByIdGenre(idGenre);
    }

    @Override
    public List<Movie> findByName(String name) {
        return iMovieRepository.findByName(name);
    }

    @Override
    public List<Movie> orderByCreationDate(String order) {
       if(order.equalsIgnoreCase("asc")){
           return iMovieRepository.orderByCreationDateAsc();
       }else if(order.equalsIgnoreCase("desc")){
            return iMovieRepository.orderByCreationDateDesc();
       }else{
           return null;
        }
    }

}
