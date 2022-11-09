

import service.PersonServiceImpl;

import java.util.Scanner;

public class FirstExerciseJDBC {
    public static void main(String[] args) {
        PersonServiceImpl dbManager = new PersonServiceImpl();
        Scanner reader = new Scanner(System.in);
        int chosenAction = 0;

        while (chosenAction != 5) {
            System.out.println("Choose an action:");
            System.out.println("1. insert a person ");
            System.out.println("2. delete a person ");
            System.out.println("3. update a person's name ");
            System.out.println("4. read some data");
            System.out.println("5. exit");
            chosenAction = reader.nextInt();

            switch (chosenAction) {
                // insert a person.
                case 1:
                    System.out.println("Person's id");
                    int id = reader.nextInt();
                    System.out.println("Person's name");
                    String name = reader.next();
                    System.out.println("Person's surname");
                    String surname = reader.next();
                    System.out.println("Person's age");
                    int age = reader.nextInt();

                    dbManager.insertPerson(id, name, surname, age);
                    break;
                // delete a person
                case 2:
                    System.out.println("Person's id");
                    dbManager.deletePersonBy(reader.nextInt());
                    break;
                // update a person
                case 3:
                    System.out.println("Person's id");
                    int searchedId = reader.nextInt();
                    System.out.println("Person's new name");
                    String newName = reader.next();

                    dbManager.updatePersonName(searchedId, newName);
                    break;
                // read some data
                case 4:
                    System.out.println("Press 1 if you wanna read all db data or " +
                            "press 2 if you wanna read a specific person" +
                            " data by id");
                    int readChoice = reader.nextInt();

                    if (readChoice == 1) {
                        // read all
                        dbManager.retrieveAll();
                    } else {
                        // read by id
                        System.out.println("Person's id");
                        dbManager.retrievePersonById(reader.nextInt());
                    }
                    break;
            }
        }
    }
}