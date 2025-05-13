import java.io.IOException;
import java.util.Arrays;

class Employees{
    String name;
    int id;
    double salary;
    public Employees(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "\n" + name + " (ID: " + id + ", Salary: " + salary + ")" ;
    }
}
public class merge{
    public static void mergeSort(Employees[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    public static void merge(Employees[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        Employees[] leftArray = new Employees[n1];
        Employees[] rightArray = new Employees[n2];
        for (int i = 0; i < n1; i++)
            leftArray[i] = arr[left + i];
        for (int i = 0; i < n2; i++)
            rightArray[i] = arr[mid + 1 + i];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].name.compareTo(rightArray[j].name) <= 0) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
        System.out.println("Intermediate sorting step(Partially sorted): \n" + Arrays.toString(arr) + "\n");
    }
    
    
    public static void main(String[] args) {
        Employees[] employees = {
new Employees("Liam", 201, 54000.75),
new Employees("Ava", 202, 78000.50),
new Employees("Zane", 203, 92000.60),
new Employees("Ella", 204, 110000.00),
new Employees("Milo", 205, 65000.25),
        };
        System.out.println("Unsorted Records:");
        System.out.println(Arrays.toString(employees));
        System.out.println("______________ \n");
        long startTime = System.nanoTime();
        mergeSort(employees, 0, employees.length - 1);
        long endTime = System.nanoTime();
        System.out.println("----------- \n"+ "Sorted Records:");
        System.out.println(Arrays.toString(employees));
        
        
        System.out.println("----------------------------------------\n \n  "+ "Time taken for sorting: " + (endTime - startTime) / 1e6 + " ms");
    }
}