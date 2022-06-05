package com.sovtech.sevices;

import com.sovtech.models.Person;

import java.util.List;

public interface PersonService {

    List<Person> getPersons();

    List<Person> searchPersons(String search);
}
