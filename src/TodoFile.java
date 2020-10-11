import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class TodoFile {
    public static Scanner openFile() {
        try {
            File f = new File("assets/todos.txt");
            return new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeFile(Scanner s) {
        s.close();
    }

    public static ArrayList<Todo> getTodos() {
        ArrayList<Todo> todos = new ArrayList<Todo>();
        String lines = "";

        // Read file
        Scanner s = openFile();

        if (s == null) {
            System.out.println("There are not todos yet. Try creating one!");
            return new ArrayList<Todo>();
        }

        while (s.hasNextLine()) {
            lines += s.nextLine();
        }

        String[] linesArray = lines.split("#");

        try {
            for (String value : linesArray) {
                String[] todoInfo = value.split(",");
                Todo todo = new Todo();

                // Assign todo values
                todo.text = todoInfo[0];
                todo.dateAdded = todoInfo[1];
                todo.completed = Boolean.parseBoolean(todoInfo[2]);

                todos.add(todo);
            }

            return todos;
        } catch (Exception e) {
            System.out.println("\nThere are not todos yet. Try creating one!\n");
            return new ArrayList<Todo>();
        }
    }

    public static void writeTodosToFile(String text, String dateAdded, String completed) {
        try {
            File file = new File("assets/todos.txt");
            FileWriter fr = new FileWriter(file, true);

            fr.write(text + ", " + dateAdded + ", " + completed + "#\n");
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found!");
        }
    }
}
