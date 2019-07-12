package io.app.movieServer.controller;

import Domain.MovieData;
import io.app.movieServer.models.Actor;
import io.app.movieServer.models.Movie;
import io.app.movieServer.repositories.ActorRepository;
import io.app.movieServer.repositories.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/movie")

public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ActorRepository actorRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Movie> getAllMovies() {
        List<Movie> movieList = movieRepository.findAll();

        List<Actor> actorList = new ArrayList<>();

        for (Movie movie : movieList) {

            MovieData movieData = new MovieData();

            movieData.set_id(movie.get_id());       //assigning all of movie data except the actors in to movie data
            movieData.setName(movie.getName());
            movieData.setYear(movie.getYear());
            movieData.setGenere(movie.getGenere());
            movieData.setDescription(movie.getDescription());
            movieData.setImgurl(movie.getImgurl());

            for (String actorId : movie.getActorIds()) {
                Actor actor = actorRepository.findBy_id(new ObjectId(actorId));
                actorList.add(actor);
            }


            movieData.setActors(actorList);      //movieData is loaded with actordata name,dob,details. this needs to be assigned in to movieList

            movieList.add();

        }
        return movieList;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public MovieData getMovie(@PathVariable("id") ObjectId id) {
        Movie movie = movieRepository.findBy_id(id);

        MovieData movieData = new MovieData();

        movieData.set_id(movie.get_id());       //assigning all of movie data except the actors in to movie data
        movieData.setName(movie.getName());
        movieData.setYear(movie.getYear());
        movieData.setGenere(movie.getGenere());
        movieData.setDescription(movie.getDescription());
        movieData.setImgurl(movie.getImgurl());

        //for loop to assign the moviedata with movie objects.
        List<Actor> actorList = new ArrayList<>();   //declaring a new list of Actor object
        for (String actorId : movie.getActorIds()) {
            ObjectId a=new ObjectId(actorId);
            Actor actor = actorRepository.findBy_id(a);

            actorList.add(actor);
        }

        movieData.setActors(actorList);     //assigning the actors list into movieData.


        return movieData;
    }


    @RequestMapping(value = "/put/{id}", method = RequestMethod.PUT)
    public void modifyMovieById(@PathVariable("id") ObjectId id, @Valid @RequestBody Movie movie) {
        movie.set_id(id);
        movieRepository.save(movie);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Movie createMovie(@Valid @RequestBody Movie movie) {
        movie.set_id(ObjectId.get());           //setting the id of movie
        movieRepository.save(movie);        //saving the movie
        return movie;           //
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMovie(@PathVariable ObjectId id) {
        movieRepository.delete(movieRepository.findBy_id(id));
    }


}
