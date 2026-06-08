package rvt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        setupDatabase();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1 - Pievienot kategoriju | 2 - Pievienot produktu | 3 - Radit visu | 0 - Iziet");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;
            
            switch (choice) {
                case 1 -> addCategory(scanner);
                case 2 -> addProduct(scanner);
                case 3 -> listAll();
            }
        }
    }

    private static void setupDatabase() {
        try (Connection conn = DatabaseConnection.connect(); Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS categories (id INTEGER PRIMARY KEY, name TEXT)");
            stmt.execute("CREATE TABLE IF NOT EXISTS products (id INTEGER PRIMARY KEY, name TEXT, price REAL, category_id INTEGER, FOREIGN KEY(category_id) REFERENCES categories(id))");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private static void addCategory(Scanner sc) {
        System.out.print("Nosaukums: ");
        String name = sc.nextLine();
        try (Connection conn = DatabaseConnection.connect(); 
             PreparedStatement ps = conn.prepareStatement("INSERT INTO categories(name) VALUES(?)")) {
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private static void addProduct(Scanner sc) {
        System.out.print("Nosaukums: "); String name = sc.nextLine();
        System.out.print("Cena: "); double price = sc.nextDouble();
        System.out.print("Kategorijas ID: "); int catId = sc.nextInt();
        
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO products(name, price, category_id) VALUES(?,?,?)")) {
            ps.setString(1, name); ps.setDouble(2, price); ps.setInt(3, catId);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private static void listAll() {
        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT p.name, p.price, c.name as catName FROM products p JOIN categories c ON p.category_id = c.id")) {
            while (rs.next()) {
                System.out.printf("Produkts: %s | Cena: %.2f | Kategorija: %s%n", rs.getString("name"), rs.getDouble("price"), rs.getString("catName"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
}

// public static void main(String[] args) {
// TodoList todoList = new TodoList();
// todoList.add("Buy groceries");
// todoList.add("Finish homework");
// todoList.add("Call mom");

// todoList.print();
// todoList.remove(2); // Remove the second task
// System.out.println("After removing task 2:");
// todoList.print();
// todoList.updateFile(1, "Buy groceries and cook dinner"); // Update the first
// task
// System.out.println("After updating task 1:");
// todoList.print();
// todoList.add("Go for a run");
// System.out.println("After adding a new task:");
// todoList.print();
// todoList.checkEventString("run"); // Check if "run" is in any task