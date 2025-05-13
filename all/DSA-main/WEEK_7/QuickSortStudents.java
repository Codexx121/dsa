import java.util.*;

public class QuickSortStudents 
{
    public static void main(String[] args) 
    {
        List<Student> list = generateList(10);

        System.out.println("Unsorted Student Records:");
        printTable(list);

        long start = System.nanoTime();
        quickSort(list, 0, list.size() - 1);
        long end = System.nanoTime();

        System.out.println("\nSorted Student Records:");
        printTable(list);
        System.out.printf("\nSorting Time: %.4f ms\n", (end - start) / 1e6);
    }

    // Quick Sort
    public static void quickSort(List<Student> list, int low, int high) 
    {
        if (low < high) 
        {
            int pi = partition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    // Partition function with intermediate display
    public static int partition(List<Student> list, int low, int high) 
    {
        String pivot = list.get(high).name;
        int i = low - 1;

        for (int j = low; j < high; j++) 
        {
            if (list.get(j).name.compareTo(pivot) <= 0) 
            {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, high);

        // Show intermediate partition step
        System.out.println("Pivot: " + pivot + " (position " + (i + 2) + ")");
        printTableRange(list, low, high);
        return i + 1;
    }

    // Generate Random Student Records
    public static List<Student> generateList(int n) 
    {
        String[] names = {"Aarav", "Bhavya", "Charan", "Divya", "Esha", "Farhan", "Gautam", "Harsh", "Ishaan", "Jaya"};
        List<Student> list = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < n; i++) 
        {
            String name = names[rand.nextInt(names.length)];
            String id = "2023A7PS0" + (100 + rand.nextInt(900)) + "U";
            double salary = 30000 + rand.nextDouble() * 50000;
            list.add(new Student(i + 1, name, id, salary));
        }
        return list;
    }

    // Print full table
    public static void printTable(List<Student> list) 
    {
        System.out.println("+-------+----------+-----------------+------------+");
        System.out.println("| S No. | Name     | ID              | Salary     |");
        System.out.println("+-------+----------+-----------------+------------+");
        for (Student s : list) System.out.println(s);
        System.out.println("+-------+----------+-----------------+------------+\n");
    }

    // Print partial table for quick sort partition step
    public static void printTableRange(List<Student> list, int low, int high) 
    {
        System.out.println("+-------+----------+-----------------+------------+");
        System.out.println("| S No. | Name     | ID              | Salary     |");
        System.out.println("+-------+----------+-----------------+------------+");
        for (int i = low; i <= high; i++) System.out.println(list.get(i));
        System.out.println("+-------+----------+-----------------+------------+\n");
    }
}

// Student class
class Student 
{
    int recNum;
    String name, id;
    double salary;

    public Student(int recNum, String name, String id, double salary) 
    {
        this.recNum = recNum;
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    @Override
    public String toString() 
    {
        return String.format("| %-5d | %-8s | %-15s | %10.2f |", recNum, name, id, salary);
    }
}
