package rvt;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    private ArrayList<String> tasks;
    private final String filePath = "todo.csv";

    public TodoList() {
        this.tasks = new ArrayList<>();
        this.loadFromFile();
    }

    private void loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) return;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Ignore empty lines or the header
                if (!line.isEmpty() && !line.startsWith("id,task")) {
                    this.tasks.add(line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private int getLastId() {
        if (this.tasks.isEmpty()) return 0;
        try {
            String lastLine = this.tasks.get(this.tasks.size() - 1);
            String[] parts = lastLine.split(",");
            return Integer.parseInt(parts[0].trim());
        } catch (Exception e) {
            return this.tasks.size();
        }
    }

    public void add(String task) {
        int newId = getLastId() + 1;
        this.tasks.add(newId + "," + task);
        this.updateFile();
    }

    private boolean updateFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("id,task");
            for (String task : this.tasks) {
                writer.println(task);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void remove(int id) {
        // Removes the string that starts with "id,"
        this.tasks.removeIf(task -> task.startsWith(id + ","));
        
        // After removing, we re-index the IDs so they stay 1, 2, 3...
        ArrayList<String> reindexedTasks = new ArrayList<>();
        for (int i = 0; i < this.tasks.size(); i++) {
            String[] parts = this.tasks.get(i).split(",", 2);
            if (parts.length > 1) {
                reindexedTasks.add((i + 1) + "," + parts[1]);
            }
        }
        this.tasks = reindexedTasks;
        updateFile();
    }

    public void print() {
        for (String entry : this.tasks) {
            // Replace the first comma with ": " for the pretty print
            System.out.println(entry.replaceFirst(",", ": "));
        }
    }
}