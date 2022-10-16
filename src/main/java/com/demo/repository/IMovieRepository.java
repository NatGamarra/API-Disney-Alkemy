package com.demo.repository;

import com.demo.entities.Character;
import com.demo.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IMovieRepository extends JpaRepository<Movie, Long> {


    @Query(value="SELECT * FROM movies WHERE id_genre LIKE %:idGenre%",
            nativeQuery = true)
    public List<Movie> findByIdGenre(@Param("idGenre") int idGenre);

    @Query(value="SELECT * FROM movies WHERE title LIKE %:name%",
            nativeQuery = true)
    public List<Movie> findByName(@Param("name") String name);

    @Query(value = "SELECT * FROM movies ORDER BY creation_date ASC",
            nativeQuery = true)
    public List<Movie> orderByCreationDateAsc();

    @Query(value = "SELECT * FROM movies ORDER BY creation_date DESC",
            nativeQuery = true)
    public List<Movie> orderByCreationDateDesc();


}
