package rvt.pakotne;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StudentRegistration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Studentu reģistrācijas sistēma");

        String vards = "";
        String uzvards = "";
        String epasts = "";
        String personasKods = "";

        try {
            System.out.println("Ievadi vārdu: ");
            vards = scanner.nextLine();
            if (!vards.matches("^[A-Za-z]{3,}$")) {
                throw new Exception("Vārds nav korekts");
            }

            System.out.println("Ievadi uzvārdu: ");
            uzvards = scanner.nextLine();
            if (!uzvards.matches("^[A-Za-z]{3,}$")) {
                throw new Exception("Uzvārds nav korekts");
            }

            System.out.println("Ievadi e-pastu: ");
            epasts = scanner.nextLine();
            if (!epasts.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                throw new Exception("E-pasts nav korekts");
            }

            System.out.println("Ievadi personas kodu (DDMMYY-XXXXX): ");
            personasKods = scanner.nextLine();
            if (!personasKods.matches("^[0-9]{6}-[0-9]{5}$")) {
                throw new Exception("Personas kods nav korekts");
            }

            String laiks = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));

            FileWriter writer = new FileWriter("students.csv");
            writer.append(vards).append(",");
            writer.append(uzvards).append(",");
            writer.append(epasts).append(",");
            writer.append(personasKods).append(",");
            writer.append(laiks).append("\n");
            writer.close();

            System.out.println("Students veiksmīgi reģistrēts!");

        } catch (Exception e) {
            System.out.println("Kļūda: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Programma beidza darbu.");
        }
    }
}
