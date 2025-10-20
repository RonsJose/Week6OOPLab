import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = 0;
        while (true) {
            System.out.print("Enter your age: ");
            String text = sc.nextLine().trim();
            try {
                age = Integer.parseInt(text);
                System.out.println("Thanks! You entered age = " + age);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input" + e.getMessage());
            }
        }

        System.out.println("Enter the file name (e.g., students.txt): ");
        String fileName = sc.nextLine().trim();

        System.out.println("Enter a name to save: ");
        String name = sc.nextLine().trim();

        try(PrintWriter out= new PrintWriter(new FileWriter(fileName, true)))
        {
            out.println(name);
            System.out.println("Saved to " + fileName);
        }catch (IOException e)
        {
            System.out.println("Could not write to file:  " + e.getMessage());
        }
    }
}
