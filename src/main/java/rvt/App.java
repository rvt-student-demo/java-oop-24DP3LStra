package rvt;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
TodoList list = new TodoList();
        Scanner scanner = new Scanner(System.in);

        UserInterface ui = new UserInterface(list, scanner);
        ui.start();

    }
}


        // ArrayList<Person> persons = new ArrayList<Person>();
        // persons.add(new Teacher("Ada Lovelace", "24 Maddox St. London W1S 2QN", 1200));
        // persons.add(new Student("Ollie", "6381 Hollywood Blvd. Los Angeles", 90028));

        // System.out.println(persons);