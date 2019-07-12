package io.app.movieServer.controller;

import io.app.movieServer.models.Actor;
import io.app.movieServer.repositories.ActorRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {


    @Autowired
    private ActorRepository repository;

    //here onwards has the mapping for REST endpoints

    @RequestMapping (value="/", method= RequestMethod.GET)
    public List<Actor> getAllActors(){
        return repository.findAll();

    }
    @RequestMapping (value="/get/{id}",method = RequestMethod.GET)
    public Actor getActor(@PathVariable ("id") ObjectId id)
    {
        return repository.findBy_id(id);
    }



    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyActorById(@PathVariable("id") ObjectId id, @Valid @RequestBody Actor actor) {
        actor.set_id(id);
        repository.save(actor);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Actor createActor(@Valid @RequestBody Actor actor) {
        actor.set_id(ObjectId.get());
        repository.save(actor);
        return actor;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteActor(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }


}
