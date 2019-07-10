package io.app.movieServer.controller;

import io.app.movieServer.models.Actors;
import io.app.movieServer.repositories.ActorsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorsController {


    @Autowired
    private ActorsRepository repository;

    //here onwards has the mapping for REST endpoints

    @RequestMapping (value="/all", method= RequestMethod.GET)
    public List<Actors> getAllActors(){
        return repository.findAll();

    }
    @RequestMapping (value="/{id}",method = RequestMethod.GET)
    public Actors getActor(@PathVariable ("id") ObjectId id)
    {
        return repository.findBy_id(id);
    }



    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyActorById(@PathVariable("id") ObjectId id, @Valid @RequestBody Actors actors) {
        actors.set_id(id);
        repository.save(actors);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Actors createActor(@Valid @RequestBody Actors actors) {
        actors.set_id(ObjectId.get());
        repository.save(actors);
        return actors;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteActor(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }


}
