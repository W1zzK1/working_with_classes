package model;

import java.time.LocalDate;

public class Person {
    public Integer id;
    public String firstName;
    public String secondName;
    public String patternalName;
    public LocalDate dateOfBirth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.matches("[а-яА-Я,a-zA-Z]+")){
            this.firstName = firstName;
        }
        else System.out.println("Не верно введено имя");
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        if (secondName.matches("[а-яА-Я,a-zA-Z]+")){
            this.secondName = secondName;
        }
        else System.out.println("Не верно введено отчество");
    }

    public String getPatternalName() {
        return patternalName;
    }

    public void setPatternalName(String patternalName) {
        if (patternalName.matches("[а-яА-Я,a-zA-Z]+")){
            this.patternalName = patternalName;
        }
        else System.out.println("Не верно введено фамилия");
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        LocalDate minimalDate = LocalDate.parse("1900-01-01"); /// Минимальная граница года, который можео ввести
        if (dateOfBirth.isBefore(minimalDate)){
            System.out.println("Не верная дата");
            return;
        }
        this.dateOfBirth = dateOfBirth;
    }

    public Person(String firstName, String secondName, String patternalName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patternalName = patternalName;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + patternalName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
