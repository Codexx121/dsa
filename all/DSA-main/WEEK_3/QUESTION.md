
# Lab Exercise 3  
### Circular Queue Implementation Using Array  

---

### Objective

An array is called **circular** if we consider the **first element as next of the last element**.

Write a **C/C++/Java** program to perform the following actions on a **QUEUE** implemented using:
- Arrays  
- Array of structures  
- Array-lists (viewed circularly)  

---

### Task Description

1. **ENQUEUE Operation**  
   - Implement the `ENQUEUE()` operation in a **circular queue** for **N (N ≥ 5)** **STUDENT RECORDS**.  
   - Each student record should store the following fields:
     - `IDNO`, `NAME`, `DOB`, `CGPA`
   - Read each student record from an input file named `studentin.dat` stored locally in your directory.
   - Insert the records into the circular queue **one at a time**.
   - *(You can use `vi` editor to create the input file. Make sure it contains at least 5 records.)*

2. **DEQUEUE Operation**  
   - Implement the `DEQUEUE()` operation in **FIFO** order.
   - Display all records on the **standard output (screen)**.
   - Also write the output results to an external file named `studentout.dat`.

3. **Display Students with CGPA < 9**  
   - Display only the **NAME** field of students whose **CGPA is less than 9**.

---

### Test Scenario

#### ✅ Test Input (from `studentin.dat`)

| ID           | NAME | DOB       | CGPA |
|--------------|------|-----------|------|
| 2021A7PS001  | AAAA | 1/1/2000  | 7.50 |
| 2021A7PS002  | BBBB | 2/1/2000  | 9.20 |
| 2021A7PS003  | CCCC | 3/1/2000  | 9.60 |
| 2021A7PS004  | DDDD | 4/1/2000  | 8.75 |
| 2021A7PS005  | EEEE | 5/1/2000  | 9.25 |

---

### Test Output (for DEQUEUE)

*(Shown on screen and written to `studentout.dat`)*


| ID           | NAME | DOB       | CGPA |
|--------------|------|-----------|------|
| 2021A7PS001  | AAAA | 1/1/2000  | 7.50 |
| 2021A7PS002  | BBBB | 2/1/2000  | 9.20 |
| 2021A7PS003  | CCCC | 3/1/2000  | 9.60 |
| 2021A7PS004  | DDDD | 4/1/2000  | 8.75 |
| 2021A7PS005  | EEEE | 5/1/2000  | 9.25 |

---

---

### Test Output (for CGPA < 9)

**Students with CGPA less than 9:**
 
| NAME |
|------|
| AAAA |
| DDDD |

