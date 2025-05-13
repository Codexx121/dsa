import java.util.*;

public class HashTableStrings
{
    static final int MAX_SIZE = 7;

    static class Node
    {
        String data;
        Node next;

        Node(String data)
        {
            this.data = data;
            this.next = null;
        }
    }

    static Node[] hashTable = new Node[MAX_SIZE];
    static boolean isInserted = false;

    // Hash function
    static int getHashValue(String input)
    {
        int sumAlpha = 0, sumDigit = 0, sumSymbol = 0;
        for (char ch : input.toCharArray())
        {
            if (Character.isLetter(ch))
            {
                sumAlpha += (int) ch;
            }
            else if (Character.isDigit(ch))
            {
                sumDigit += (int) ch;
            }
            else
            {
                sumSymbol += (int) ch;
            }
        }
        return (sumAlpha + 3 * sumDigit + 5 * sumSymbol + 7) % MAX_SIZE;
    }

    // Insert into hash table using chaining
    static void insert(String str)
    {
        int index = getHashValue(str);
        Node newNode = new Node(str);
        newNode.next = hashTable[index];
        hashTable[index] = newNode;
    }

    // Display hash table
    static void displayHashTable()
    {
        if (!isInserted)
        {
            System.out.println("Please insert the initial data first using Option 1.");
            return;
        }

        System.out.println("\nHash Table:");
        System.out.println("----------------------");
        for (int i = 0; i < MAX_SIZE; i++)
        {
            System.out.printf("[%d]: ", i);
            Node temp = hashTable[i];
            if (temp == null)
            {
                System.out.println("null");
                continue;
            }
            while (temp != null)
            {
                System.out.print(temp.data);
                temp = temp.next;
                if (temp != null)
                {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }

    // Search for a key
    static void search(String key)
    {
        if (!isInserted)
        {
            System.out.println("Please insert the initial data first using Option 1.");
            return;
        }
        int index = getHashValue(key);
        Node temp = hashTable[index];
        while (temp != null)
        {
            if (temp.data.equals(key))
            {
                System.out.println(key + " found at index " + index);
                return;
            }
            temp = temp.next;
        }
        System.out.println(key + " not found.");
    }

    // Delete a key
    static void delete(String key)
    {
        if (!isInserted)
        {
            System.out.println("Please insert the initial data first using Option 1.");
            return;
        }
        int index = getHashValue(key);
        Node temp = hashTable[index];
        Node prev = null;

        while (temp != null)
        {
            if (temp.data.equals(key))
            {
                if (prev == null)
                {
                    hashTable[index] = temp.next;
                }
                else
                {
                    prev.next = temp.next;
                }
                System.out.println(key + " deleted from index " + index);
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println(key + " not found to delete.");
    }

    // Reset hash table
    static void resetHashTable()
    {
        Arrays.fill(hashTable, null);
        isInserted = false;
        System.out.println("Hash table has been reset.");
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] inputs = {
            "M2y", "N3x", "F4w", "O5v", "D*2u", "A2t", "K5#y", "M6z", "N7a", "Y3w",
            "b2Y", "e3X", "f4W", "c5V", "d2U", "a2T", "J5Y", "m6%z", "n7A", "y3W"
        };

        while (true)
        {
            System.out.println("\nMENU:");
            System.out.println("1. Display hash values and insert initial 20 strings");
            System.out.println("2. Display hash table");
            System.out.println("3. Delete a key");
            System.out.println("4. Search a key");
            System.out.println("5. Reset hash table");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // clear invalid input
                continue;
            }
            scanner.nextLine(); // consume newline

            switch (choice)
            {
                case 1:
                    if (isInserted) {
                        System.out.println("Initial data already inserted!");
                        break;
                    }
                    System.out.println("\nInput: " + String.join(" ", inputs));
                    System.out.println("Output:");
                    for (String str : inputs)
                    {
                        int hash = getHashValue(str);
                        System.out.println("Hash value for " + str + " = " + hash);
                        insert(str); // silent insert
                    }
                    isInserted = true;
                    break;

                case 2:
                    displayHashTable();
                    break;

                case 3:
                    System.out.print("Enter key to delete: ");
                    String delKey = scanner.nextLine();
                    delete(delKey);
                    break;

                case 4:
                    System.out.print("Enter key to search: ");
                    String searchKey = scanner.nextLine();
                    search(searchKey);
                    break;

                case 5:
                    resetHashTable();
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
