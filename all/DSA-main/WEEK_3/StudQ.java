import java.io.*;
import java.util.*;

class Student 
{
    String idNo;
    String name;
    String dob;
    double cgpa;

    public Student(String idNo, String name, String dob, double cgpa) 
    {
        this.idNo = idNo;
        this.name = name;
        this.dob = dob;
        this.cgpa = cgpa;
    }

    @Override
    public String toString() 
    {
        return idNo + " " + name + " " + dob + " " + cgpa;
    }
}

class CirQ 
{
    private Student[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CirQ(int capacity) 
    {
        this.capacity = capacity;
        this.array = new Student[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(Student student) 
    {
        if (isFull()) 
        {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        if (isEmpty()) 
        {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        array[rear] = student;
        size++;
    }

    public Student dequeue() 
    {
        if (isEmpty()) 
        {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        Student student = array[front];
        if (front == rear) 
        {
            front = -1;
            rear = -1;
        } else 
        {
            front = (front + 1) % capacity;
        }
        size--;
        return student;
    }

    public boolean isEmpty() 
    {
        return size == 0;
    }

    public boolean isFull() 
    {
        return size == capacity;
    }

    public int size() 
    {
        return size;
    }
}

public class StudQ {
    public static void main(String[] args) 
    {
        CirQ queue = new CirQ(5);

        // 1. Implement ENQUEUE operation
        try (BufferedReader br = new BufferedReader(new FileReader("studentin.dat"))) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] parts = line.split("\\s+");
                Student student = new Student(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
                queue.enqueue(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Implement DEQUEUE operation and display/write results
        try (PrintWriter writer = new PrintWriter(new FileWriter("studentout.dat"))) 
        {
            while (!queue.isEmpty()) 
            {
                Student student = queue.dequeue();
                System.out.println(student);
                writer.println(student);
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }

        // 3. Display student names with CGPA less than 9
        System.out.println("\nNAME");
        try (BufferedReader br = new BufferedReader(new FileReader("studentin.dat"))) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] parts = line.split("\\s+");
                double cgpa = Double.parseDouble(parts[3]);
                if (cgpa < 9.0) 
                {
                    System.out.println(parts[1]);
                }
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}

