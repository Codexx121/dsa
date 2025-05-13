import java.util.Scanner;
class Node {
    String str;
    Node left, right;
    Node(String str) {
        this.str = str;
        left = right = null;
    }
}
class BSTstring {
    Node root;
    Node insert(Node root, String str) {
        if (root == null) {
            return new Node(str);
        }
        if (str.compareTo(root.str) < 0) {
            root.left = insert(root.left, str);
        } else {
            root.right = insert(root.right, str);
        }
        return root;
    }

    boolean search(Node root, String str) {
        if (root == null) return false;
        if (root.str.equals(str)) return true;
        return str.compareTo(root.str) < 0 ? search(root.left, str) : search(root.right, str);
    }

    Node findMax(Node root) {
        while (root.right != null) root = root.right;
        return root;
    }
    
    Node delete(Node root, String str) {
        if (root == null) return null;
        if (str.compareTo(root.str) < 0) {
            root.left = delete(root.left, str);
        } else if (str.compareTo(root.str) > 0) {
            root.right = delete(root.right, str);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            Node pred = findMax(root.left);
            root.str = pred.str;
            root.left = delete(root.left, pred.str);
        }
        return root;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.str + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.str + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.str + " ");
        }
    }
}

public class BST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BSTstring tree = new BSTstring();
        int choice;
        do {
            System.out.println("\nBST Operations");
            System.out.println("1.Insert Node\n2.Search\n3.Delete node\n4.Pre-order Traversal\n5.In-order Traversal\n6.Post-order Traversal \n0.Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the string to insert: ");
                    String insertStr = sc.nextLine();
                    tree.root = tree.insert(tree.root, insertStr);
                    System.out.print("Current Tree's Inorder Traversal: ");
                    tree.inorder(tree.root);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter data to search: ");
                    String searchStr = sc.nextLine();
                    boolean found = tree.search(tree.root, searchStr);
                    System.out.println(found ? "Element found: " + searchStr : "Element not found!");
                    break;
                case 3:
                    System.out.print("Enter the string to delete: ");
                    String deleteStr = sc.nextLine();
                    if (tree.search(tree.root, deleteStr)) {
                        tree.root = tree.delete(tree.root, deleteStr);
                        System.out.println("Deleted: " + deleteStr);
                    } else {
                        System.out.println("Data not found in tree!");
                    }
                    break;
                case 4:
                    System.out.print("PREORDER: ");
                    tree.preorder(tree.root);
                    System.out.println();
                    break;
                case 5:
                    System.out.print("INORDER: ");
                    tree.inorder(tree.root);
                    System.out.println();
                    break;
                case 6:
                    System.out.print("POSTORDER: ");
                    tree.postorder(tree.root);
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
        sc.close();
    }
}