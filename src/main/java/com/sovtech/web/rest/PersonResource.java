package com.sovtech.web.rest;

import com.sovtech.models.Person;
import com.sovtech.sevices.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class PersonResource {

    private static final Logger log = LoggerFactory.getLogger(PersonResource.class);

    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public ResponseEntity<List<Person>> findPersons() {
        log.info("Rest request to get persons");
        List<Person> persons = this.personService.getPersons();
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/person/")
    public ResponseEntity<List<Person>> findPersons(@RequestParam String search) {
        log.info("Rest request to search persons : {} ", search);
        List<Person> persons = this.personService.searchPersons(search);
        return ResponseEntity.ok(persons);
    }
}
