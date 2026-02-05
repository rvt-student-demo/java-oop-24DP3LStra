package rvt;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class App {

    public static void main(String[] args) {
        File file = new File("data/todo.csv");
        try {
            Scanner reader = new Scanner(file);
            System.out.println(
                reader.nextLine()
            );
        }
        catch (FileNotFoundException e){

        }

    }
}

// ArrayList<Person> persons = new ArrayList<Person>();
// persons.add(new Teacher("Ada Lovelace", "24 Maddox St. London W1S 2QN",
// 1200));
// persons.add(new Student("Ollie", "6381 Hollywood Blvd. Los Angeles", 90028));

// System.out.println(persons);