# Lab Exercise 1  

### Objective

Write a C/C++/Java program to perform the following actions on a **STACK** implemented using arrays or array of structures:

---

### Requirements

1. **PUSH Operation**  
   Implement the PUSH operation in a STACK for **N (N ≥ 5)** **STUDENT RECORDS**.  
   Each STUDENT RECORD should store:
   - `IDNO`
   - `NAME`
   - `DOB`
   - `CGPA`  
   You must read each STUDENT record from an input file named `studentin.dat` stored locally in your directory, and then **PUSH** each record into the stack, one at a time.  
   *(You may use the `vi` editor to create the input data file. Ensure it contains at least 5 records.)*

2. **POP Operation**  
   Implement the POP operation for the STACK in **LIFO** order and display **all** the records on:
   - the **standard output** (screen)
   - an **external file** named `studentout.dat`

---

### Test Scenario

#### Test Input  
*(read from external file: `studentin.dat`)*

| ID           | NAME | DOB       | CGPA |
|--------------|------|-----------|------|
| 2021A7PS001  | AAAA | 1/1/2000  | 7.50 |
| 2021A7PS002  | BBBB | 2/1/2000  | 9.20 |
| 2021A7PS003  | CCCC | 3/1/2000  | 9.60 |
| 2021A7PS004  | DDDD | 4/1/2000  | 8.75 |
| 2021A7PS005  | EEEE | 5/1/2000  | 9.25 |

---

#### Test Output  
*(displayed on screen and written to `studentout.dat`)*

| ID           | NAME | DOB       | CGPA |
|--------------|------|-----------|------|
| 2021A7PS005  | EEEE | 5/1/2000  | 9.25 |
| 2021A7PS004  | DDDD | 4/1/2000  | 8.75 |
| 2021A7PS003  | CCCC | 3/1/2000  | 9.60 |
| 2021A7PS002  | BBBB | 2/1/2000  | 9.20 |
| 2021A7PS001  | AAAA | 1/1/2000  | 7.50 |

---
