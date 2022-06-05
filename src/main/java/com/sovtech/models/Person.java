package com.sovtech.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private Set<String> films = new HashSet<>();
    private Set<Object> species = new HashSet<>();
    private Set<String> vehicles = new HashSet<>();
    private Set<String> starships = new HashSet<>();
    private Instant created;
    private Instant edited;
    private String url;
}
