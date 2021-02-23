package edu.spring.rest;

import edu.spring.domain.Person;
import edu.spring.repostory.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final PersonRepository repository;

    @Autowired
    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/persons/{id}")
    public Person one(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @GetMapping(value = "/persons")
    public List<Person> all() {
        return repository.findAll();
    }

    @DeleteMapping(value = "/persons/{id}")
    public void deletePerson(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @PostMapping(value = "/persons")
    public void savePerson(@RequestBody Person person) {
        repository.save(person);
    }
}
