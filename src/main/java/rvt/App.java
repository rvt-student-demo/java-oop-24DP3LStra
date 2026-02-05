package rvt;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class App {

    public static void main(String[] args) {
        File file = new File("data/todo.csv");
        try (Scanner reader = new Scanner(new File("data/data.csv"))){
            reader.nextLine();
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                String[] parts = row.split(",");
                String name = parts[0];
                int age = Integer.valueOf(parts[1]);
                int id = Integer.valueOf(parts[2]);
                String email = parts[3];
                String course = parts[4];
                double gpa = Double.valueOf(parts[5]);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Error" + e.getMessage());
        }

    }
}

// ArrayList<Person> persons = new ArrayList<Person>();
// persons.add(new Teacher("Ada Lovelace", "24 Maddox St. London W1S 2QN",
// 1200));
// persons.add(new Student("Ollie", "6381 Hollywood Blvd. Los Angeles", 90028));

// System.out.println(persons);