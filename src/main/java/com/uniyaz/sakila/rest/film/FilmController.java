package com.uniyaz.sakila.rest.film;

import com.uniyaz.sakila.core.film.domain.Film;
import com.uniyaz.sakila.core.film.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "film")
public class FilmController {

    @Autowired
    FilmService filmService;

    @PostMapping(path= "save")
    public ResponseEntity save(@RequestBody Film film){
        return filmService.save(film);
    }

    @GetMapping(path = "findAll")
    public ResponseEntity findAll(){
        return filmService.findAll();
    }

    @DeleteMapping(path = "delete")
    public ResponseEntity delete(@RequestParam Long id){
        return filmService.delete(id);
    }
}
