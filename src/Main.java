import controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.addPersonView();
        controller.showPersons();

//        controller.findPersonWithId();
//
//        controller.deletePerson();

        controller.updatePerson();
    }
}