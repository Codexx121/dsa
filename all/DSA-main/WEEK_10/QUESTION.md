# Lab Exercise 10  

## Objective

Write an **algorithm** and a **C/C++/Java** program to implement a **Binary Search Tree (BST)** storing **strings** as keys.

---

## Instructions

- Create a BST node structure:

```java
class Node {
    String str;
    Node left, right;
}
```

- Insert nodes:
  - Lexicographically **less** → left subtree
  - Lexicographically **greater or same** → right subtree
- Deletion using **Inorder Predecessor Replacement**.

---

## Supported Operations

- **Insert Node**
- **Search Node**
- **Delete Node** (using inorder predecessor)
- **Traversals**:
  - Pre-order
  - In-order
  - Post-order

### Additional (Optional)

- Find **Smallest String** (alphabetically)
- Find **Largest String** (alphabetically)
- Find **Height** of BST
- Count:
  - Total Nodes
  - Total Internal Nodes
  - Total Leaf Nodes

---

## Sample Input/Output

### Insertion

```
Insert: pencil → Tree: pencil
Insert: feather → Tree: feather pencil
Insert: river → Tree: feather pencil river
Insert: stone → Tree: feather pencil river stone
Insert: garden → Tree: feather garden pencil river stone
Insert: apple → Tree: apple feather garden pencil river stone
Insert: blanket → Tree: apple blanket feather garden pencil river stone
Insert: penguin → Tree: apple blanket feather garden pencil penguin river stone
```

### Search

```
Search: blanket → Found
Search: rain → Not Found
```

### Deletion

```
Delete: reel → Data not found
Delete: river → Successfully deleted
```

### Traversals

- **Inorder:** apple blanket feather garden pencil penguin stone
- **Preorder:** pencil feather apple blanket garden penguin stone
- **Postorder:** blanket apple garden feather stone penguin pencil

---

## Notes

- BST ensures faster search, insert, and delete operations.
- Traversals help verify the structure and correctness of the tree.

---
