package com.demo.controllers;
import com.demo.entities.Genre;
import com.demo.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController {

    @Autowired
    private IGenreService iGenreService;

    @PostMapping("save/genre")
    public ResponseEntity<?> saveGenre(@RequestBody Genre genre){
        iGenreService.saveGenre(genre);
        return new ResponseEntity<>(genre, HttpStatus.CREATED);
    }

}
