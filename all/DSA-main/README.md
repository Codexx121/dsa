# Data Structures and Algorithms Lab  
**Semester 2 (2025-26)**  
**Language:** Java  

This repository contains Java programs for weekly lab exercises in the **Data Structures and Algorithms (DSA)** course. Each folder corresponds to one week of lab work and includes well-documented code based on standard algorithmic techniques.

---

## Folder-wise Breakdown

### WEEK1 — Stack Operations using Arrays
- Implement a stack using arrays.
- Push and pop multiple student records (`ID, Name, DOB, CGPA`) read from a file.
- Write popped records to an output file.

### WEEK2 — Infix to Postfix Conversion & Evaluation
- Convert a user-entered **infix expression** to **postfix**.
- Evaluate the postfix expression using stack.
- Custom stack implementation (no in-built stack classes allowed).

### WEEK3 — Circular Queue using Array
- Implement a circular queue for student records.
- Perform enqueue and dequeue operations using a file.
- Display students whose CGPA is less than 9.

### WEEK4 — Doubly Linked List (DLL)
- Maintain a sorted DLL of student records by ID.
- Menu-driven operations:
  - Add, delete, search by ID
  - Display in descending order
  - Find student with highest CGPA

### WEEK5 — Linear and Binary Search
- Initialize an array with 10,000+ float values.
- Implement and compare Linear Search vs Binary Search.
- Measure and print search time and iteration count.

### WEEK6 — Merge Sort
- Sort a list of employee records (`Name, ID, Salary`) by **name** using Merge Sort.
- Show intermediate merging stages.
- Display unsorted and sorted lists.
- Measure execution time.

### WEEK7 — Quick Sort
- Read and store multiple student records (`Name, ID, CGPA`).
- Sort the records in **ascending order of CGPA** using **Quick Sort (recursive)**.
- Display intermediate array states after each partition.
- Show unsorted and sorted records.
- Measure and display the **time taken for sorting**.

### WEEK8 — Hash Table with Chaining
- Implement a **Hash Table** using **Separate Chaining** (Linked Lists).
- Compute hash value using a custom ASCII-based hash function.
- Insert multiple strings into the table and manage collisions via chaining.
- Perform search and delete operations.
- Display the hash table after each operation.

### WEEK9 — Hash Table with Open Addressing
- Implement a **Hash Table** using **Open Addressing**:
  - **Linear Probing** and **Quadratic Probing** for collision resolution.
- Compute hash values using a custom formula.
- Support operations:
  - Add keys
  - Search for keys
  - Delete keys
  - Display the full table showing EMPTY, OCCUPIED, and DELETED states.

### WEEK10 — Binary Search Tree (BST)
- Implement a **Binary Search Tree (BST)** to store strings as keys.
- Support operations:
  - Insert, Search, Delete (with **Inorder Predecessor** replacement).
  - Pre-order, In-order, and Post-order traversals.
- (Optional) Additional operations:
  - Find smallest/largest string
  - Find height of BST
  - Count total nodes, internal nodes, and leaf nodes.

---

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/ShamScripts/DSA.git
    ```
2. Navigate to any week's folder.
3. Compile and run the Java files using:
   ```bash
   javac FileName.java
   java FileName
   ```
### Notes

- All programs are written in **Java** with a focus on **clarity** and **modularity**.
- **File handling** and **user interaction** are incorporated where relevant.
- **Timer functions** are used for **performance analysis** in applicable labs.

---

### Author

Maintained by **[ShamScripts](https://github.com/ShamScripts)** for academic use as part of the *DSA Lab Course*, Semester 2 (2025-26).

---
