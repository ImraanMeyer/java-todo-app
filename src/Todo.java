import java.util.Scanner;

public class Todo {
    // Attributes
    String text;
    String dateAdded;
    boolean completed;

    public static Scanner s = new Scanner(System.in);

    public Todo(String text, String dateAdded, boolean completed) {
        this.text = text;
        this.dateAdded = dateAdded;
        this.completed = completed;
    }

    public Todo() {};

    public void printTodo() {
        String output = "";
        output += "Todo: " + text;
        output += "\nDate Added: " + dateAdded;
        output += "\nCompleted: " + completed;

        System.out.println(output + "\n");
    }

    public void markTodoComplete () {
        this.completed = true;
        System.out.println("Todo successfully marked complete.");
        this.printTodo();
    }



    public void updateTodoText() {
        System.out.println("\n=== Enter New Todo Text ===\n");
        this.text = s.nextLine();
        this.printTodo();
    }

    public void updateDateAdded() {
        System.out.println("\n=== Enter New Date ===\n");
        this.dateAdded = s.nextLine();
        this.printTodo();
    }
}
