# Lab Exercise 4  
### Doubly Linked List (DLL) Implementation

---

### Objective

Write a **C/C++/Java** program to implement a **Doubly Linked List (DLL)** to store the following student information:
- **Name** (String)
- **Student IDNO** (int)
- **Branch** (CS, BT, CE, CHE, EEE)
- **CGPA** (float)

The program should be **menu-driven** and allow the user to perform the following operations repeatedly until they choose to **Exit**.

---

### Tasks

1. **Add Student**  
   Add a new student such that the **list remains sorted** in **ascending order of Student IDNO**, regardless of insertion order.  
   *(Assume Student ID numbers are unique)*

2. **Delete Student**  
   Delete a student record from the list by providing their **Student IDNO**.

3. **Search Student**  
   Search and display the details of a student using their **Student IDNO**.

4. **Display All Students**  
   Display all student records in **descending order** of IDNO.

5. **Best Performer**  
   Search and display the **student with the highest CGPA**.

6. **Exit**  
   Exit the program gracefully.

---

### Sample Input/Output

**Options:**

- Add student  
- Delete student  
- Search Student  
- Display all  
- Best performer  
- Exit  

**Enter your choice:** `1`  
**Enter name, idno, branch & cgpa:** `Amit 101 CS 8.76`  
**Output:** Addition Success!

**Options:**

- Add student  
- Delete student  
- Search Student  
- Display all  
- Best performer  
- Exit  

**Enter your choice:** `1`  
**Enter name, idno, branch & cgpa:** `Rohan 102 EEE 8.59`  
**Output:** Addition Success!

**Options:**

- Add student  
- Delete student  
- Search Student  
- Display all  
- Best performer  
- Exit  

**Enter your choice:** `3`  
**Enter IDNO of student to search:** `102`  

**Student details are:**  
- **Name:** Rohan  
- **IDNO:** 102  
- **Branch:** EEE  
- **CGPA:** 8.59  

**Options:**

- Add student  
- Delete student  
- Search Student  
- Display all  
- Best performer  
- Exit  

**Enter your choice:** `4`  

**All Students’ details are:**  

| Name  | IDNO | Branch | CGPA |
|-------|------|--------|------|
| Rohan | 102  | EEE    | 8.59 |
| Amit  | 101  | CS     | 8.76 |

**Options:**

- Add student  
- Delete student  
- Search Student  
- Display all  
- Best performer  
- Exit  

**Enter your choice:** `5`  

**Student with highest CGPA is:**  
- **Name:** Amit  
- **IDNO:** 101  
- **Branch:** CS  
- **CGPA:** 8.76  


**Options:**

- Add student  
- Delete student  
- Search Student  
- Display all  
- Best performer  
- Exit  

**Enter your choice:** `6`  
**Output:** Bye Bye!

---

### Notes

- Make sure to handle edge cases (e.g., searching/deleting from an empty list).
- Maintain both forward and backward pointers properly to support DLL operations.
- Ensure memory is properly freed in case of deletion or exit (if applicable).

---
