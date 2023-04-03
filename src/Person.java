import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Person {
    private String firstName;
    private String secondName;
    private String lastName;
    private LocalDate dateOfBirth;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.matches("[а-яА-Я,a-zA-Z]+")){
            this.lastName = lastName;
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

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
