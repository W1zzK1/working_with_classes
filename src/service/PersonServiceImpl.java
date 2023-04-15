package service;

import model.Person;
import storage.PersonStorage;

import java.util.List;

public class PersonServiceImpl implements PersonService {
    public PersonStorage storage = new PersonStorage();

    public void showPersons() {
        List<Person> allPeople = storage.getAllPersons();
        for (Person person : allPeople) {
            System.out.println(person);
        }
    }

    public void createPerson(String firstName, String secondName, String paternalName) {
        Person person = new Person(firstName, secondName, paternalName);
        storage.addPerson(person);
    }

    public void deletePerson(int id){
        storage.deletePerson(id);
    }
    public void findPersonWithId(Integer id) {
        Person a = storage.findPersonWithId(id);
        System.out.println(a);
    }

    public void updatePerson(int id, Person newPerson) {
        storage.updatePerson(id, newPerson);
    }

    private boolean validateString(String s) {
        return s.matches("\\d");
    }
}
