package service;

import model.Person;
import storage.PersonStorage;

public class PersonServiceImpl implements PersonService {
    public PersonStorage storage = new PersonStorage();

    public Person[] showPersons() {
        return storage.getAllPersons();
    }

    public Person createPerson(String firstName, String secondName, String paternalName) {
        Person person = new Person(firstName, secondName, paternalName);
        storage.addPerson(person);
        return person;
    }

    public void findPersonWithId(Integer id) {
        storage.findPersonWithId(id);
    }

    public void updateName(Integer id, String newName) {
        return;
    }

    private boolean validateString(String s) {
        return s.matches("\\d");
    }
}
