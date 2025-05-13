import java.util.*;

class HashNode {
    String key;
    HashNode next;
    HashNode(String key) {
        this.key = key;
        this.next = null;
    }
}

public class HashTable {
    static final int MAX_SIZE = 7;
    HashNode[] table = new HashNode[MAX_SIZE];
    int getHash(String key) {
        int sumAlpha = 0, sumDigit = 0, sumSymbol = 0;
        for (char c : key.toCharArray()) {
            if (Character.isLetter(c))
                sumAlpha += (int) c;
            else if (Character.isDigit(c))
                sumDigit += (int) c;
            else
                sumSymbol += (int) c;
        }
        int hash = (sumAlpha + 3 * sumDigit + 5 * sumSymbol + 7) % MAX_SIZE;
        return hash;
    }

    void insert(String key) {
        int index = getHash(key);
        HashNode newNode = new HashNode(key);
        newNode.next = table[index];
        table[index] = newNode;
    }

    void display() {
        System.out.println("\nHash table:");
        for (int i = 0; i < MAX_SIZE; i++) {
            System.out.print("[" + i + "]:");
            HashNode current = table[i];
            while (current != null) {
                System.out.print(" -> " + current.key);
                current = current.next;
            }
            System.out.println();
        }
    }
 
    void search(String key) {
        int index = getHash(key);
        HashNode current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                System.out.println("\nKey \"" + key + "\" found at index " + index);
                return;
            }
            current = current.next;
        }
        System.out.println("\nKey \"" + key + "\" not found");
    }

    void delete(String key) {
        int index = getHash(key);
        HashNode current = table[index];
        HashNode prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null)
                    table[index] = current.next;
                else
                    prev.next = current.next;
                System.out.println("\nKey \"" + key + "\" deleted");
                return;
            }
            prev = current;
            current = current.next;
        }
        System.out.println("\nKey \"" + key + "\" not found for deletion");
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable();
        String[] input = {
            "M2y", "N3x", "F4w", "O5v", "D*2u", "A2t", "K5#y", "M6z", "N7a", "Y3w",
            "b2Y", "e3X", "f4W", "c5V", "d2U", "a2T", "J5Y", "m6%Z", "n7A", "y3W"
        };
        for (String key : input) {
            System.out.println("Hash value for " + key + " = " + ht.getHash(key));
            ht.insert(key);
        }
        ht.display();
        ht.delete("b2Y");
        ht.display();
        ht.search("a2T");
        ht.search("wew423");
    }
}
