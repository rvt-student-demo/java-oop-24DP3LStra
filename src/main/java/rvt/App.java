package rvt;

public class App {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        todoList.add("Buy groceries");
        todoList.add("Finish homework");
        todoList.add("Call mom");

        todoList.print();
        todoList.remove(2); // Remove the second task
        System.out.println("After removing task 2:");
        todoList.print();
        todoList.updateFile(1, "Buy groceries and cook dinner"); // Update the first task
        System.out.println("After updating task 1:");
        todoList.print();
        todoList.add("Go for a run");
        System.out.println("After adding a new task:");
        todoList.print(); 
        todoList.checkEventString("run"); // Check if "run" is in any task
    }
}