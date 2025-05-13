import java.util.Scanner;

public class LinProb
{
    static final int MAX_SIZE = 7;

    enum Status
    {
        EMPTY, OCCUPIED, DELETED
    }

    static class Entry
    {
        String key;
        Status status;

        Entry()
        {
            key = "";
            status = Status.EMPTY;
        }
    }

    static Entry[] table = new Entry[MAX_SIZE];

    static
    {
        for (int i = 0; i < MAX_SIZE; i++)
        {
            table[i] = new Entry();
        }
    }

    static int hashFunction(String key)
    {
        int sumAlpha = 0, sumDigits = 0, sumSymbols = 0;
        for (char ch : key.toCharArray())
        {
            if (Character.isLetter(ch))
            {
                sumAlpha += (int) ch;
            }
            else if (Character.isDigit(ch))
            {
                sumDigits += (int) ch;
            }
            else
            {
                sumSymbols += (int) ch;
            }
        }
        return (sumAlpha + 3 * sumDigits + 5 * sumSymbols + 7) % MAX_SIZE;
    }

    static void insert(String key)
    {
        int hash = hashFunction(key);
        int i = 0;

        while (i < MAX_SIZE)
        {
            int index = (hash + i) % MAX_SIZE;

            if (table[index].status == Status.EMPTY || table[index].status == Status.DELETED)
            {
                table[index].key = key;
                table[index].status = Status.OCCUPIED;
                System.out.println("Key " + key + " added at index " + index);
                return;
            }
            i++;
        }
        System.out.println("Hash Table is full. Could not insert " + key);
    }

    static void search(String key)
    {
        int hash = hashFunction(key);
        int i = 0;

        while (i < MAX_SIZE)
        {
            int index = (hash + i) % MAX_SIZE;

            if (table[index].status == Status.EMPTY)
            {
                break;
            }

            if (table[index].status == Status.OCCUPIED && table[index].key.equals(key))
            {
                System.out.println("Key found!!");
                return;
            }
            i++;
        }
        System.out.println("Key not Found!!");
    }

    static void delete(String key)
    {
        int hash = hashFunction(key);
        int i = 0;

        while (i < MAX_SIZE)
        {
            int index = (hash + i) % MAX_SIZE;

            if (table[index].status == Status.EMPTY)
            {
                break;
            }

            if (table[index].status == Status.OCCUPIED && table[index].key.equals(key))
            {
                table[index].status = Status.DELETED;
                table[index].key = "";
                System.out.println("Deleted " + key);
                return;
            }
            i++;
        }
        System.out.println("Key not Found!!");
    }

    static void display()
    {
        System.out.println("\n--- Full Hash Table ---");
        for (int i = 0; i < MAX_SIZE; i++)
        {
            System.out.print(i + ": ");
            if (table[i].status == Status.EMPTY)
            {
                System.out.println("EMPTY");
            }
            else if (table[i].status == Status.DELETED)
            {
                System.out.println("DELETED");
            }
            else
            {
                System.out.println(table[i].key);
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        while (true)
        {
            System.out.print("\nEnter your choice: 1. Add 2. Search 3. Delete 4. Display 5. Exit:: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice)
            {
                case 1:
                    System.out.print("Enter the string to add: ");
                    insert(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Enter the string to search: ");
                    search(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Enter the string to delete: ");
                    delete(sc.nextLine());
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
