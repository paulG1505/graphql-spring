package com.paul.graphql.graphql;

import com.paul.graphql.documents.Person;
import com.paul.graphql.repositories.PersonRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonQuery implements GraphQLQueryResolver {

    private PersonRepository personRepository;

    @Autowired
    public PersonQuery(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> persons() {
        return this.personRepository.findAll();
    }

    public Person person(String id) {
        Optional<Person> personDb = this.personRepository.findById(id);
        return personDb.get();
    }
}
