package controller;

import model.Person;
import service.PersonService;
import service.PersonServiceImpl;

import java.util.Scanner;

public class Controller {
    Scanner sc = new Scanner(System.in);

    PersonServiceImpl service = new PersonServiceImpl();

    public void addPersonView() {
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

    public void showPersons() {
        service.showPersons();
    }

    public void findPersonWithId() {
        System.out.print("Введите Id для поиска : ");
        int idPersonToFind = sc.nextInt();
        service.findPersonWithId(idPersonToFind);
    }

    public void deletePerson() {
        System.out.print("Введите Id для удаления : ");
        int id = sc.nextInt();
        service.deletePerson(id);
        service.showPersons();
    }

    public void updatePerson() {
        boolean correctId = false;
        int id = 0;
        while (!correctId) {
            try {
                System.out.print("Введите id пользователя для обновления данных : ");
                id = Integer.valueOf(sc.nextLine());
                correctId = true;
            } catch (NumberFormatException e) {
                System.out.println("Введен не верный Id");
            }

        }

        System.out.print("Введите новое имя : ");
        String newFirstname = sc.nextLine();

        System.out.print("Введите новую фамилию : ");
        String newSecondName = sc.nextLine();

        System.out.print("Введите новое отчество : ");
        String newPaternalName = sc.nextLine();

        Person newPerson = new Person(newFirstname, newSecondName, newPaternalName);
        try {
            service.updatePerson(id, newPerson);
            service.findPersonWithId(id);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Такого Id не существует");
            updatePerson();
        }
    }
}
