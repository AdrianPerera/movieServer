package io.app.movieServer.repositories;

import io.app.movieServer.models.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MovieRepository extends MongoRepository<Movie, String >
{  Movie findBy_id(ObjectId _id);

}

