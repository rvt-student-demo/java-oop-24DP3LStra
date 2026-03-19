package rvt.pakotne;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Ievadi vārdu: ");
            String vards = scanner.nextLine();

            System.out.println("Ievadi uzvārdu: ");
            String uzvards = scanner.nextLine();

            System.out.println("Ievadi epastu: ");
            String epasts = scanner.nextLine();

            System.out.println("Ievadi personas kodu: ");
            String personasKods = scanner.nextLine();

            StudentRegistration.registerStudent(vards, uzvards, epasts, personasKods);
            System.out.println("Students ir veiksmīgi pievienots");
        }

        catch (Exception e) {
            System.out.println("Kļūda " + e.getMessage());
        }
        finally {
            scanner.close();
            System.out.println("Programa pabeidza darbu");
        }
    }
}
