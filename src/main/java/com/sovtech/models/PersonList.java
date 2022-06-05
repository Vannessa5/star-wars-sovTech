package com.sovtech.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PersonList {
    // to convert to a List or results object.
    private List<Person> results = new ArrayList<Person>();
}
