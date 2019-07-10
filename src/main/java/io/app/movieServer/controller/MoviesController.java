package io.app.movieServer.controller;

import io.app.movieServer.models.Movies;
import org.bson.types.ObjectId;
import io.app.movieServer.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/movies")

public class MoviesController {
    @Autowired
    private MoviesRepository repository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Movies> getAllMovies() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Movies getMovie(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyMovieById(@PathVariable("id") ObjectId id, @Valid @RequestBody Movies movies) {
        movies.set_id(id);
        repository.save(movies);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Movies createMovie(@Valid @RequestBody Movies movies) {
        movies.set_id(ObjectId.get());
        repository.save(movies);
        return movies;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMovie(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }


}
