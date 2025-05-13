import java.util.Scanner;

class Student {
    String name, branch;
    int id;
    double cgpa;
    Student prev, next;

    Student(String name, int id, String branch, double cgpa) {
        this.name = name;
        this.id = id;
        this.branch = branch;
        this.cgpa = cgpa;
        this.prev = this.next = null;
    }
}

class StudentDLL {
    private Student head;

    // Insert student in sorted order by ID
    void addStudent(String name, int id, String branch, double cgpa) {
        Student newStudent = new Student(name, id, branch, cgpa);
        if (head == null || head.id > id) {
            newStudent.next = head;
            if (head != null) head.prev = newStudent;
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.id < id) {
            temp = temp.next;
        }
        newStudent.next = temp.next;
        if (temp.next != null) temp.next.prev = newStudent;
        temp.next = newStudent;
        newStudent.prev = temp;
    }

    // Delete student by ID
    void deleteStudent(int id) {
        Student temp = head;
        while (temp != null && temp.id != id) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Student not found!");
            return;
        }
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp == head) head = temp.next;
        System.out.println("Student deleted!");
    }

    // Search for a student by ID
    void searchStudent(int id) {
        Student temp = head;
        while (temp != null && temp.id != id) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Student not found!");
        } else {
            System.out.println("Name: " + temp.name + "\nID: " + temp.id + "\nBranch: " + temp.branch + "\nCGPA: " + temp.cgpa);
        }
    }

    // Display all students in descending order of ID
    void displayAll() {
        if (head == null) {
            System.out.println("No students found!");
            return;
        }
        Student temp = head;
        while (temp.next != null) temp = temp.next; // Move to last node
        System.out.println("\nAll Students:");
        while (temp != null) {
            System.out.println(temp.name + " " + temp.id + " " + temp.branch + " " + temp.cgpa);
            temp = temp.prev;
        }
    }

    // Find and display student with highest CGPA
    void bestPerformer() {
        if (head == null) {
            System.out.println("No students found!");
            return;
        }
        Student temp = head, best = head;
        while (temp != null) {
            if (temp.cgpa > best.cgpa) best = temp;
            temp = temp.next;
        }
        System.out.println("Best Performer: " + best.name + " ID: " + best.id + " CGPA: " + best.cgpa);
    }
}

public class w4q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDLL dll = new StudentDLL();

        while (true) {
            System.out.println("\nOptions: 1. Add student 2. Delete student 3. Search Student 4. Display all 5. Best performer 6. Exit");
            int choice = sc.nextInt();
            if (choice == 6) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter name, ID, branch & CGPA: ");
                    dll.addStudent(sc.next(), sc.nextInt(), sc.next(), sc.nextDouble());
                    System.out.println("Addition Success!");
                    break;
                case 2:
                    System.out.print("Enter ID to delete: ");
                    dll.deleteStudent(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter ID to search: ");
                    dll.searchStudent(sc.nextInt());
                    break;
                case 4:
                    dll.displayAll();
                    break;
                case 5:
                    dll.bestPerformer();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
        System.out.println("Bye!");
    }
}


