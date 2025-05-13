import java.util.Scanner;

public class SearchAlgo
{
    public static void main(String[] args)
    {
        int size = 100000;
        float[] arr = new float[size];
        for (int i = 0; i < size; i++)
        {
            arr[i] = i;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter search key: ");
        float key = sc.nextFloat();
        sc.close();

        long start = System.nanoTime();
        int linIdx = linearSearch(arr, key);
        System.out.println("Linear Search:\nIndex: " + linIdx + "\nTime (µs): " + (System.nanoTime() - start) / 1000.0);

        start = System.nanoTime();
        int binIdx = binarySearch(arr, key);
        System.out.println("\nBinary Search:\nIndex: " + binIdx + "\nTime (µs): " + (System.nanoTime() - start) / 1000.0);
    }

    public static int linearSearch(float[] arr, float key)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print("Checking index: " + i + " ");
            if (arr[i] == key)
            {
                System.out.println("\nFound at index: " + i);
                return i;
            }
        }
        System.out.println("\nNot Found");
        return -1;
    }

    public static int binarySearch(float[] arr, float key)
    {
        int low = 0, high = arr.length - 1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            System.out.print("Checking index: " + mid + " ");
            if (arr[mid] == key)
            {
                System.out.println("\nFound at index: " + mid);
                return mid;
            }
            else if (arr[mid] < key)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        System.out.println("\nNot Found");
        return -1;
    }
}
