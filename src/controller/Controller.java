package controller;

import model.Person;
import service.PersonServiceImpl;

import java.util.Scanner;

public class Controller {
    Scanner sc = new Scanner(System.in);

    PersonServiceImpl service = new PersonServiceImpl();

    public void addPersonView(){
        for (int i = 0; i < 2; i++) {
            Person person = new Person();
            System.out.print("Введите имя : ");
            String firstName = sc.nextLine();
            person.setFirstName(firstName);

            System.out.print("Введите фамилию : ");
            String secondName = sc.nextLine();
            person.setFirstName(secondName);

            System.out.print("Введите отчество : ");
            String patternalName = sc.nextLine();
            person.setFirstName(patternalName);

            service.createPerson(firstName, secondName, patternalName);
        }
    }
    public void showPersons(){
        Person[] allPeople = service.showPersons();
        for (Person p : allPeople){
            System.out.println(p);
        }
    }
}
