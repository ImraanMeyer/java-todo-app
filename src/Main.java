import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //    private static String s;
    public static Scanner s = new Scanner(System.in);

    public static String menu() {
        return "1: View Todo's\n2: Create Todo\n3: Delete Todo\n4: Update Todo's\n5: Finalise Todo\n6: Exit";
    }

    public static void returnAllTodos() {
        for (int i = 0; i < todos.size(); i++) {
            System.out.println("Todo: #" + (i + 1));
            todos.get(i).printTodo();
        }
    }

    public static ArrayList<Todo> todos = TodoFile.getTodos();

    public static void main(String[] args) throws IOException {
        // Todo Variables
        String todoText = "";
        String dateAdded = "";
        boolean completed = false;

        // Program status:
        boolean running = true;
        // User Input
        String userInput;
        // Todo Instance
        Todo todo = null;

        while (running) {
            System.out.println(menu());
            userInput = s.nextLine();

            // Capture User input
            switch (userInput) {
                case "1":
                    if (todos.isEmpty()) {
                        System.out.println("\nThere are not todos yet. Try creating one!\n");
                    } else {
                        System.out.println("\n====== All Todos ======\n");
                        returnAllTodos();
                    }
                    break;
                case "2":
                    System.out.println("\n====== Create New Todo ======\n");
                    System.out.println("Enter todo:");
                    todoText = s.nextLine();
                    System.out.println("Enter date added");
                    dateAdded = s.nextLine();

                    // Create new todo
                    todo = new Todo(todoText, dateAdded, completed);
                    todo.printTodo();
                    break;
                case "3":
                    returnAllTodos();
                    System.out.println("\n====== Delete Todo ======\nInsert a todo number to delete\n");

                    userInput = s.nextLine();
                    todos.remove(Integer.parseInt(userInput) - 1);
                    break;
                case "4":
                    if (todo != null) {
                        System.out.println("\n====== Update Todo ======\n");
                        System.out.println("1: Mark Complete\n2: Change Todo\n3: Change Date Added");

                        String userSelection = s.nextLine();
                        switch (userSelection) {
                            case "1":
                                todo.markTodoComplete();
                                completed = true;
                                break;
                            case "2":
                                todo.updateTodoText();
                                break;
                            case "3":
                                todo.updateDateAdded();
                                break;
                        }
                    } else System.out.println("\nThere are not todo's to edit! Create one\n");
                    break;
                case "5":
                    TodoFile.writeTodosToFile(todoText, dateAdded, String.valueOf(completed));
                    System.out.println("Todo written to text file successfully!");
                    break;
                case "6":
                    running = false;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + userInput);
            }
        }
    }
}
