package storage;

import model.Person;

import java.util.Objects;

public class PersonStorage {
    private Person[] allPersons = new Person[10];
    private int index = 0;

    public Person addPerson(Person person) {
        allPersons[index] = person;
        person.setId(index);
        index++;
        return person;
    }

    void deletePerson(Integer id) {
    }

    public Person[] getAllPersons() {
        return allPersons;
    }

    Person updateName(Integer id, String newName) {
        return new Person();
    }

    public void findPersonWithId(Integer id) {
        for (Person i : allPersons) {
            if (Objects.equals(id, i.id)) {
                System.out.println(i);
                break;
            }
        }
    }
}
