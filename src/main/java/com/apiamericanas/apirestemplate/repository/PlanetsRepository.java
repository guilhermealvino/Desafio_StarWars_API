package com.apiamericanas.apirestemplate.repository;

import com.apiamericanas.apirestemplate.model.Planet;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanetsRepository extends MongoRepository<Planet, String> {
    Planet findBy_id(ObjectId _id);
    Planet findPlanetByNameEquals(String name);
}