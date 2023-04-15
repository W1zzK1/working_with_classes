package storage;

import model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonStorage {
    private List<Person> allPersons = new ArrayList<>();
    private int index = 0;

    public void addPerson(Person person) {
        allPersons.add(person);
        index++;
    }

    public void deletePerson(int id) {
        allPersons.remove(id);
    }

    public List<Person> getAllPersons() {
        return new ArrayList<>(allPersons);
    }

    public Person updatePerson(int id, Person person) {
        return allPersons.set(id, person);
    }

    public Person findPersonWithId(int id) {
        return allPersons.get(id);
    }
}
