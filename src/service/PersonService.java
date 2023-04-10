package service;

import model.Person;

public interface PersonService {
    Person createPerson(String firstName, String secondName, String patternalName);

    Person[] showPersons();
}
