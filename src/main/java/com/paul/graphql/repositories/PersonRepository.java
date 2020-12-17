package com.paul.graphql.repositories;

import com.paul.graphql.documents.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
