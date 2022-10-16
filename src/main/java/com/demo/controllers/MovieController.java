package com.demo.controllers;
import com.demo.entities.Movie;
import com.demo.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value ="/movies")
@RestController
public class MovieController {

    @Autowired
    private IMovieService iMovieService;

    //Obtener todas las peliculas
    @GetMapping
    public ResponseEntity<?> getMovies(){
        return new ResponseEntity<>(iMovieService.getMovies(), HttpStatus.OK);
    }

    //Buscar pelicula por id
    @GetMapping("/{id}")
    public ResponseEntity<?> findMovie(@PathVariable Long id) {
        return new ResponseEntity<>(iMovieService.findMovie(id), HttpStatus.OK);
    }

    //Crear pelicula
    @PostMapping("/save")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
        iMovieService.saveMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }


    //Eliminar pelicula por id
    @DeleteMapping("/{idMovie}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long idMovie) {
        iMovieService.deleteMovie(idMovie);
        return new ResponseEntity<>("Eliminado con exito", HttpStatus.OK);
    }

    //Editar pelicula
    @PutMapping("/edit")
    public ResponseEntity<?> editMovie(@RequestBody Movie movie){
        iMovieService.editMovie(movie);
        return new ResponseEntity<>(iMovieService.findMovie(movie.getId()),HttpStatus.OK);
    }

    //Filtro de peliculas por idGenre
    @RequestMapping(value="",params = "genre",method = RequestMethod.GET)
    public ResponseEntity<?> findByIdGenre(@RequestParam int idGenre){
        return new ResponseEntity<>(iMovieService.findByIdGenre(idGenre), HttpStatus.OK);
    }
    //Busqueda por titulo
    @RequestMapping(value="",params = "name",method = RequestMethod.GET)
    public ResponseEntity<?>  findByName(@RequestParam String name){
        return new ResponseEntity<>(iMovieService.findByName(name), HttpStatus.OK);
    }
    //Orden asc o desc
    @RequestMapping(value="",params = "order",method = RequestMethod.GET)
    public ResponseEntity<?> orderByCreationDate(@RequestParam String order) {
    return new ResponseEntity<>(iMovieService.orderByCreationDate(order), HttpStatus.OK);
    }

}
