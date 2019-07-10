package io.app.movieServer.repositories;

import io.app.movieServer.models.Actors;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActorsRepository extends MongoRepository<Actors,String>{
    Actors findBy_id(ObjectId _id);
}
