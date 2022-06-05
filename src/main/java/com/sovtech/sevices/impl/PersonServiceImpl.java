package com.sovtech.sevices.impl;

import com.sovtech.models.Person;
import com.sovtech.models.PersonList;
import com.sovtech.sevices.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${base-url}")
    private String url;

//both endpoints were tested on Insomia.
    @Override
    public List<Person> getPersons() {
        log.info("Request to get person: {}");
        PersonList response = null;
        try {
            response = restTemplate.getForObject(url, PersonList.class);
            return response.getResults();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Person> searchPersons(String search) {
        log.info("Request to get person: {}", search);
        PersonList response = null;
        url += "?search=" + search;
        try {
            response = restTemplate.getForObject(url, PersonList.class);
            return response.getResults();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
