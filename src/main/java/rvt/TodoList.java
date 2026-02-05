package rvt;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    private ArrayList tasks;
    private final String filePath = "data/todo.csv";

    public TodoList() {
        this.tasks = new ArrayList<>();

    }

    private void loadFromFile(){

    }

    public void add(String task) {
        tasks.add(task);
    }

    // private boolean updateFile(){

    // }




    public void print() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ": " + tasks.get(i));
        }
    }

    // private int getLastId(){

    // }

    public void remove(int number) {
        // number is 1-based, ArrayList is 0-based
        tasks.remove(number - 1);
    }
}
