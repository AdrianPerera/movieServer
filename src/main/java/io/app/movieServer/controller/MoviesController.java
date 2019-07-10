package io.app.movieServer.controller;//package io.app.movieServer.controller;
//import org.bson.types.ObjectId;
//import io.app.movieServer.models.Movies;
//import io.app.movieServer.repositories.MoviesRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/movies")
//
//public class MoviesController {
//    @Autowired
//    private MoviesRepository repository;
//
//    @RequestMapping(value = "/movies/all", method = RequestMethod.GET)
//    public List<Movies> getAllMovies() {
//        return repository.findAll();
//    }
//
//    @RequestMapping(value = "movies/{id}", method = RequestMethod.GET)
//    public Movies getMovie(@PathVariable("id") ObjectId id) {
//        return repository.findBy_id(id);
//    }
//
//}
