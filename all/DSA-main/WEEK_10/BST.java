import java.util.Scanner;

class BSTNode
{
    String str;
    BSTNode left, right;

    public BSTNode(String str)
    {
        this.str = str;
        left = right = null;
    }
}

class StringTree
{
    BSTNode root;

    public void insert(String str)
    {
        root = insertRec(root, str);
    }

    private BSTNode insertRec(BSTNode node, String str)
    {
        if (node == null)
        {
            return new BSTNode(str);
        }
        if (str.compareTo(node.str) < 0)
        {
            node.left = insertRec(node.left, str);
        }
        else
        {
            node.right = insertRec(node.right, str);
        }
        return node;
    }

    public boolean search(String str)
    {
        return searchRec(root, str);
    }

    private boolean searchRec(BSTNode node, String str)
    {
        if (node == null)
        {
            return false;
        }
        if (node.str.equals(str))
        {
            return true;
        }
        if (str.compareTo(node.str) < 0)
        {
            return searchRec(node.left, str);
        }
        else
        {
            return searchRec(node.right, str);
        }
    }

    public void delete(String str)
    {
        root = deleteRec(root, str);
    }

    private BSTNode deleteRec(BSTNode node, String str)
    {
        if (node == null)
        {
            return null;
        }
        if (str.compareTo(node.str) < 0)
        {
            node.left = deleteRec(node.left, str);
        }
        else if (str.compareTo(node.str) > 0)
        {
            node.right = deleteRec(node.right, str);
        }
        else
        {
            if (node.left == null)
            {
                return node.right;
            }
            else if (node.right == null)
            {
                return node.left;
            }
            BSTNode predecessor = getMax(node.left);
            node.str = predecessor.str;
            node.left = deleteRec(node.left, predecessor.str);
        }
        return node;
    }

    private BSTNode getMax(BSTNode node)
    {
        while (node.right != null)
        {
            node = node.right;
        }
        return node;
    }

    public void inorder()
    {
        System.out.print("INORDER: ");
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(BSTNode node)
    {
        if (node != null)
        {
            inorderRec(node.left);
            System.out.print(node.str + " ");
            inorderRec(node.right);
        }
    }

    public void preorder()
    {
        System.out.print("PREORDER: ");
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(BSTNode node)
    {
        if (node != null)
        {
            System.out.print(node.str + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    public void postorder()
    {
        System.out.print("POSTORDER: ");
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(BSTNode node)
    {
        if (node != null)
        {
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.print(node.str + " ");
        }
    }
}

public class BST
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StringTree tree = new StringTree();

        while (true)
        {
            System.out.println("\nBST Operations\n==========");
            System.out.println("1.Insert Node  2.Search  3.Delete Node");
            System.out.println("4.Pre-order Traversal  5.In-order Traversal  6.Post-order Traversal");
            System.out.println("0.Exit");
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice)
            {
                case 1:
                {
                    System.out.print("Enter the string to insert: ");
                    String ins = sc.nextLine();
                    tree.insert(ins);
                    tree.inorder();
                    break;
                }
                case 2:
                {
                    System.out.print("Enter data to search: ");
                    String sea = sc.nextLine();
                    if (tree.search(sea))
                    {
                        System.out.println("Element found: " + sea);
                    }
                    else
                    {
                        System.out.println("Element not found!");
                    }
                    break;
                }
                case 3:
                {
                    System.out.print("Enter the string to delete: ");
                    String del = sc.nextLine();
                    tree.delete(del);
                    tree.inorder();
                    break;
                }
                case 4:
                {
                    tree.preorder();
                    break;
                }
                case 5:
                {
                    tree.inorder();
                    break;
                }
                case 6:
                {
                    tree.postorder();
                    break;
                }
                case 0:
                {
                    System.exit(0);
                }
                default:
                {
                    System.out.println("Invalid choice!");
                }
            }
        }
    }
}
