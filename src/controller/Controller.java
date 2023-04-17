package controller;

import exception.IlligalDataException;
import model.Person;
import service.PersonService;
import service.PersonServiceImpl;

import java.util.Scanner;

public class Controller {
    PersonServiceImpl service = new PersonServiceImpl();

    public void addPersonView() {
        boolean correctFlag = false;
        while (!correctFlag) {
            try (Scanner sc = new Scanner(System.in)){
                service.createPerson(readData(sc));
                correctFlag = true;
            } catch (IlligalDataException e) {
                System.out.println("Произошла ошибка при вводе данных, попробуйте заново");
                correctFlag = false;
            }
        }
//        Scanner sc = new Scanner(System.in);
//        for (int i = 0; i < 2; i++) {
//            service.createPerson(readData(sc));
//        }
    }

    private Person readData(Scanner sc) {

        Person person = new Person();
        System.out.print("Введите имя : ");
        String firstName = sc.nextLine();
        if (validateString(firstName)) {
            person.setFirstName(firstName);
        } else {
            System.out.println("Не корректное имя, начните заново");
            throw new IlligalDataException("Не корректное имя");
        }

        System.out.print("Введите фамилию : ");
        String secondName = sc.nextLine();
        if (validateString(secondName)) {
            person.setSecondName(secondName);
        } else {
            System.out.println("Не корректная фамилия, начните заново");
            throw new IlligalDataException("Не корректная фамилия");
        }

        System.out.print("Введите отчество : ");
        String patternalName = sc.nextLine();
        if (validateString(patternalName)) {
            person.setPatternalName(patternalName);
        } else {
            System.out.println("Не корректное отчество, начните заново");
            throw new IlligalDataException("Не корректное отчество");
        }

        return person;

    }

    public void showPersons() {
        service.showPersons();
    }

    public void findPersonWithId() {
        boolean correctFlag = false;
//        int idPersonToFind = 0;
        while (!correctFlag) {
//            try (Scanner sc = new Scanner(System.in)) {
//                System.out.print("Введите Id для поиска : ");
//                idPersonToFind = sc.nextInt();
//                service.findPersonWithId(idPersonToFind);
//                correctFlag = true;
//            } catch (RuntimeException e){
//                correctFlag = false;
//            }
            try {
                try {
                    int idPersonToFind = 0;
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Введите Id для поиска : ");
                    idPersonToFind = Integer.valueOf(sc.nextLine());
                    service.findPersonWithId(idPersonToFind);
                    correctFlag = true;
                    sc.close();
                } catch (NumberFormatException e) {
                    System.out.println("Id может быть только числом, попробуйте еще раз");
                    throw new IlligalDataException("Id может быть только числом");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Такого Id не существует, попробуйте еще раз");
                    throw new IlligalDataException("Такого Id не существует");
                }
            } catch (RuntimeException e) {
                correctFlag = false;
            }
        }
    }

    public void deletePerson() {
        boolean correctId = false;
        while (!correctId) {
            try {
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Введите Id для удаления : ");
                    int id = Integer.valueOf(sc.nextLine());
                    service.deletePerson(id);
                    service.showPersons();
                    correctId = true;
                    sc.close();
                } catch (NumberFormatException e) {
                    System.out.println("Id может быть только числом, попробуйте еще раз");
                    throw new IlligalDataException("Id может быть только числом");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Такого Id не существует, попробуйте еще раз");
                    throw new IlligalDataException("Такого Id не существует");
                }
            } catch (RuntimeException e) {
                correctId = false;
            }
        }
    }

    public void updatePerson() {
        boolean correctId = false;
        while (!correctId) {
                try (Scanner sc = new Scanner(System.in)){
                    System.out.print("Введите id пользователя для обновления данных : ");
                    int id = Integer.valueOf(sc.nextLine());
                    service.updatePerson(id, readData(sc));
                    service.findPersonWithId(id);
                    correctId = true;
                } catch (NumberFormatException e) {
                    System.out.println("Id может быть только числом, попробуйте еще раз");
                    throw new IlligalDataException("Id может быть только числом");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Такого Id не существует, попробуйте еще раз");
                    throw new IlligalDataException("Такого Id не существует");
                } catch (RuntimeException e) {}
        }
    }

    private boolean validateString(String s) {
        if (s.matches("[а-яА-Я,a-zA-Z]+")) {
            return true;
        } else throw new IlligalDataException("Не корректные данные");
    }
}
