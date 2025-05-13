import java.util.*;
public class HashTable {
    static final int MAX_SIZE = 7;
    static String[] table = new String[MAX_SIZE];
    static String DELETED = "<DELETED>";
    
    static int getHashValue(String str) {
        int alphaSum = 0, digitSum = 0, symbolSum = 0;
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                alphaSum += (int) ch;
            } else if (Character.isDigit(ch)) {
                digitSum += (int) ch;
            } else {
                symbolSum += (int) ch;
            }
        }
        return (alphaSum + 3 * digitSum + 5 * symbolSum + 7) % MAX_SIZE;
    }
    
    static void insert(String str) {
        int hash = getHashValue(str);
        int i = 0;
        int index;
        while (i < MAX_SIZE) {
            index = (hash + i * i) % MAX_SIZE;
            if (table[index] == null || table[index].equals(DELETED)) {
                table[index] = str;
                System.out.println("Key " + str + "has been added at index " + index);
                return;
            } else 
            {
                System.out.println("Collision detected @index " + index + " for key:" + str + ",Occupied by: " + table[index]);
            }
            i++;
        }
        System.out.println("Table is full, cannot insert value" + str);
    }
    
    static boolean search(String str) {
        int hash = getHashValue(str);
        int i = 0;
        while (i < MAX_SIZE) {
            int index = (hash + i * i) % MAX_SIZE;
            if (table[index] == null) return false;
            if (table[index].equals(str)) return true;
            i++;
        }
        return false;
    }
    
    static void delete(String str) {
        int hash = getHashValue(str);
        int i = 0;
        while (i < MAX_SIZE) {
            int index = (hash + i * i) % MAX_SIZE;
            if (table[index] == null) return;
            if (table[index].equals(str)) {
                table[index] = DELETED;
                System.out.println("Deleted " + str);
                return;
            }
            i++;
        }
    }

    static void displayTable() {
        System.out.println("\n--- Full Hash Table ---");
        for (int i = 0; i < MAX_SIZE; i++) {
            if (table[i] == null) {
                System.out.println(i + ": EMPTY");
            } else if (table[i].equals(DELETED)) {
                System.out.println(i + ": DELETED");
            } else {
                System.out.println(i + ": " + table[i]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        String key;
        while (true) {
            System.out.print("\nEnter your choice: \n1. Add \n2. Search \n3. Delete \n4. Display \n5. Exit\n");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter the string to be added:");
                    key = sc.nextLine();
                    insert(key);
                    break;
                case 2:
                    System.out.print("Enter the string to be searched:");
                    key = sc.nextLine();
                    System.out.println(search(key) ? "Key has been found!" : "Key has not been Found!!");
                    break;
                case 3:
                    System.out.print("Enter the string to be deleted:");
                    key = sc.nextLine();
                    delete(key);
                    break;
                case 4:
                    displayTable();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
