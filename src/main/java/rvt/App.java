package rvt;

public class App {
    public static void main(String[] args) {
        TodoList list = new TodoList();
        list.print();
        list.remove(2);
        list.print();
        list.add("Go to the gym");
        list.print();
        list.remove(1);
        list.remove(1);

        list.print();

    }
}