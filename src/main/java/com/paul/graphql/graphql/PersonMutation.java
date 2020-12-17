package com.paul.graphql.graphql;

import com.paul.graphql.documents.Person;
import com.paul.graphql.repositories.PersonRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class PersonMutation implements GraphQLMutationResolver {

    public PersonRepository personRepository;

    @Autowired
    public PersonMutation(PersonRepository personRepository) {

        this.personRepository = personRepository;
    }

    public Person createPerson(Person person) {
        return this.personRepository.save(person);
    }

    public Person updatePerson(String id, Person person) {
        Optional<Person> personDb = this.personRepository.findById(id);
        Person personUpdate = personDb.get();
        personUpdate.setName(person.getName());
        personUpdate.setEmail(person.getEmail());
        personUpdate.setAddress(person.getAddress());
        personUpdate.setAge(person.getAge());
        personUpdate.setPhone(person.getPhone());
        return this.personRepository.save(personUpdate);
    }

    public Person deletePerson(String id) {
        Optional<Person> personDb = this.personRepository.findById(id);
        Person person = personDb.get();
        this.personRepository.deleteById(id);
        return person;
    }
}
