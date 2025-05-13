import java.io.*;
import java.util.*;

class Student {
    String id, name, dob;
    double cgpa;

    public Student(String id, String name, String dob, double cgpa) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.cgpa = cgpa;
    }
}

class CircularQueue {
    private Student[] queue;
    private int front, rear, size, capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new Student[capacity];
        front = rear = -1;
        size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(Student student) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        if (front == -1) front = 0;
        rear = (rear + 1) % capacity;
        queue[rear] = student;
        size++;
    }

    public Student dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        Student temp = queue[front];
        front = (front + 1) % capacity;
        size--;
        return temp;
    }
}

public class w3q1 {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        List<Student> students = new ArrayList<>();

        // Reading from file
        try (BufferedReader br = new BufferedReader(new FileReader("studentin.dat"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                String id = parts[0];
                String name = parts[1];
                String dob = parts[2];
                double cgpa = Double.parseDouble(parts[3]);
                Student student = new Student(id, name, dob, cgpa);
                queue.enqueue(student);
                students.add(student);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        // Dequeue and write to output file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("studentout.dat"))) {
            while (!queue.isEmpty()) {
                Student s = queue.dequeue();
                String output = s.id + " " + s.name + " " + s.dob + " " + s.cgpa;
                System.out.println(output);
                bw.write(output);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }

        // Display students with CGPA < 9
        System.out.println("\nStudents with CGPA < 9:");
        for (Student s : students) {
            if (s.cgpa < 9) {
                System.out.println(s.name);
            }
        }
    }
}


