package rvt;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    private ArrayList tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public void add(String task) {
        tasks.add(task);
    }

    public void print() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ": " + tasks.get(i));
        }
    }

    public void remove(int number) {
        // number is 1-based, ArrayList is 0-based
        tasks.remove(number - 1);
    }
}
