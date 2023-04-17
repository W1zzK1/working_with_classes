package service;

import model.Person;
import storage.PersonStorage;

import java.util.List;
import java.util.Scanner;

public class PersonServiceImpl implements PersonService {
    public PersonStorage storage = new PersonStorage();

    public void showPersons() {
        List<Person> allPeople = storage.getAllPersons();
        for (Person person : allPeople) {
            System.out.println(person);
        }
    }

    public void createPerson(Person person) {
//        Person person = new Person(firstName, secondName, paternalName);
//        if (validateString(firstName) && validateString(secondName) && validateString(paternalName)){
//        } throw new RuntimeException("Неккоректные данные");
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
