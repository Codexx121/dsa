import java.util.*;

class Student {
    String name;
    int id;
    double cgpa;
    Student(String name, int id, double cgpa) {
        this.name = name;
        this.id = id;
        this.cgpa = cgpa;
    }

    public String toString() {
        return "Name: " + name + ", ID: " + id + ", CGPA: " + cgpa;
    }
}

public class qs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        int numStudents = 5;  
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter Student " + (i + 1) + " Name:");
            String name = scanner.nextLine();
            System.out.println("Enter Student " + (i + 1) + " ID:");
            int id = scanner.nextInt();
            System.out.println("Enter Student " + (i + 1) + " CGPA:");
            double cgpa = scanner.nextDouble();
            scanner.nextLine(); 
            students.add(new Student(name, id, cgpa));
        }
        System.out.println("\nUnsorted Records:");
        for (Student student : students) {
            System.out.println(student);
        }
        long startTime = System.nanoTime();
        quickSort(students, 0, students.size() - 1);
        long endTime = System.nanoTime();
        System.out.println("\nSorted Records:");
        for (Student student : students) {
            System.out.println(student);
        }
        long duration = endTime - startTime;
        System.out.println("\nSorting Time: " + duration + "ns");
    }

    public static void quickSort(List<Student> students, int first, int last) {
        if (first < last) {
            int partInd = partition(students, first, last);
            quickSort(students, first, partInd - 1);
            quickSort(students, partInd + 1, last);
        }
    }

    public static int partition(List<Student> students, int first, int last) {
        double pivot = students.get(last).cgpa;
        int i = (first - 1);

        for (int j = first; j < last; j++) {
            if (students.get(j).cgpa <= pivot) {
                i++;
                Collections.swap(students, i, j);
            }
        }
        Collections.swap(students, i + 1, last);
        System.out.println("\nPartition Step:");
        for (Student student : students) {
            System.out.println(student);
        }
        return i + 1;
    }
}