package com.demo.service;
import com.demo.entities.Genre;
import com.demo.repository.IGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GenreService implements IGenreService {

    @Autowired
    private IGenreRepository iGenreRepository;

    @Override
    public Genre saveGenre(Genre genre) {
        return iGenreRepository.save(genre);
    }
}
