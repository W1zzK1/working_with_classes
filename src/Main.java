import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Person[] allPersons = new Person[2];

        for (int i = 0; i < 2; i++){
            Scanner scan = new Scanner(System.in);

            Person person = new Person();

            System.out.print("Введите имя : ");
            String firstName = scan.nextLine();
            person.setFirstName(firstName);

            System.out.print("Введите отчество : ");
            String secondName = scan.nextLine();
            person.setSecondName(secondName);

            System.out.print("Введите фамилию : ");
            String lastName = scan.nextLine();
            person.setLastName(lastName);

            System.out.print("Введите дату рождения : ");
            String dateOfBirth = scan.nextLine();
            LocalDate date = LocalDate.parse(dateOfBirth);
            person.setDateOfBirth(date);

            allPersons[i] = person;
        }

        for (int i = 0; i < allPersons.length; i++){
            System.out.println(allPersons[i]);
        }
    }
}