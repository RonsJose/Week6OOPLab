import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = 0;
        while (true) {
            System.out.print("Enter your age: ");
            String text = sc.nextLine().trim();// Enters age as string so as not to skip a line and gets rid of whitespace
            try { // Execption handling
                age = Integer.parseInt(text); // Parsing string into integer for age
                System.out.println("Thanks! You entered age = " + age);
                break;
            } catch (NumberFormatException e) {// Incase something goes wrong
                System.out.println("Invalid input" + e.getMessage());// show small message  instead of long error message
            }
        }

        System.out.println("Enter the file name (e.g., students.txt): ");
        String fileName = sc.nextLine().trim();

        System.out.println("Enter a name to save: ");
        String name = sc.nextLine().trim();

        try(PrintWriter out= new PrintWriter(new FileWriter(fileName,true))) //Using exception handling and writing to file so theres no need to close yourself
        {
            out.println(name);
            System.out.println("Saved to " + fileName);
        }catch (IOException ex) //error handling
        {
            System.out.println("Could not write to file:  " + ex.getMessage());
        }

        BufferedReader br = null;
        try{
            FileReader neverUsed = new FileReader("students.txt"); // reading from file students.txt
            br= new BufferedReader(neverUsed);
            System.out.println("Contents of students.txt: ");
            String line;
            while((line=br.readLine())!=null) //reading lines from students.txt until theres none
            {
                System.out.println(" - "+line);
            }
        }catch (IOException ex)//error handling
        {
            System.out.println("Could not read from file:  " + ex.getMessage());
        }
        finally
        {
            if (br != null) // Checks if the file has closed
            {
                try {
                    br.close(); //tries closing the stream
                } catch (IOException closeEx) {
                    System.out.println("Could not close file:  " + closeEx.getMessage());
                }
            }
        }
    }
}
