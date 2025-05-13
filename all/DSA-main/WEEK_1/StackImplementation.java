import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Class to represent a student record
class Student {
    String id;
    String name;
    String dob;
    double cgpa;

    public Student(String id, String name, String dob, double cgpa) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + dob + "\t" + cgpa;
    }
}

// Stack class using an array
class StudentStack {
    private Student[] stackArray;
    private int top;
    private int capacity;

    public StudentStack(int capacity) {
        this.capacity = capacity;
        stackArray = new Student[capacity];
        top = -1;
    }

    public void push(Student student) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stackArray[++top] = student;
        System.out.println(student.id + " pushed into the stack");
    }

    public Student pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return null;
        }
        return stackArray[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class StackImplementation {
    public static void main(String[] args) {
        StudentStack stack = new StudentStack(50);
        int count = 0;

        // Read data from file and push onto stack
        try {
            File inputFile = new File("studentin.dat");
            Scanner reader = new Scanner(inputFile);

            System.out.println("\nINPUT STARTS\n");

            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if (!line.isEmpty()) { // Ignore empty lines
                    String[] parts = line.split("\\s+");
                    if (parts.length == 4) {
                        String id = parts[0];
                        String name = parts[1];
                        String dob = parts[2];
                        double cgpa = Double.parseDouble(parts[3]);

                        Student student = new Student(id, name, dob, cgpa);
                        stack.push(student);
                        count++;
                    } else {
                        System.out.println("Skipping invalid line: " + line);
                    }
                }
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found.");
            e.printStackTrace();
        }

        // Pop and write to file
        System.out.println("\n\nOUTPUT STARTS\n");
        System.out.println("ID\t\tNAME\tDOB\tCGPA");
        System.out.println("==========================================");

        try {
            FileWriter writer = new FileWriter("studentout.dat");

            while (!stack.isEmpty()) {
                Student student = stack.pop();
                if (student != null) {
                    System.out.println(student);
                    writer.write(student + "\n");
                }
            }

            writer.close();
            System.out.println("\nSuccessfully written to studentout.dat file.");
        } catch (IOException e) {
            System.out.println("Error: Unable to write to output file.");
            e.printStackTrace();
        }

        System.out.println("\nThe code has successfully run.");
    }
}
