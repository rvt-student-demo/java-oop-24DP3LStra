package rvt.pakotne;

import java.io.FileWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class StudentRegistration {

    public static void registerStudent(String vards, String uzvards, String epasts, String personasKods) throws Exception {

        if (!vards.matches("^[A-Za-zĀ-ž]{3,}$")) {
            throw new Exception("Vārds nav korekts");
        }

        if (!uzvards.matches("^[A-Za-zĀ-ž]{3,}$")) {
            throw new Exception("Uzvārds nav korekts");
        }

        if (!epasts.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new Exception("Epasts nav korekts");
        }

        if (!personasKods.matches("^[0-9]{6}-[0-9]{5}$")) {
            throw new Exception("Personas kods nav korekts");
        }

        // Correct path
        String path = "src/main/java/rvt/pakotne/data/students.csv";

        // Ensure folder exists
        File folder = new File("src/main/java/rvt/pakotne/data");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File file = new File(path);

        // Count existing lines to generate next ID
        int nextId = 1;
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                while (reader.readLine() != null) {
                    nextId++;
                }
            }
        }

        String time = LocalDateTime.now(ZoneId.of("Europe/Riga"))
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        // Write student entry
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.append(String.valueOf(nextId)).append(",");
            writer.append(vards).append(",");
            writer.append(uzvards).append(",");
            writer.append(epasts).append(",");
            writer.append(personasKods).append(",");
            writer.append(time).append("\n");
        }
    }
}
