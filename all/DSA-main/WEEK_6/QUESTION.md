# Lab Exercise 6  

### Aim: Implementation of Merge-Sort

Write a **C/C++/Java** program to perform the following:

---

###  Tasks

#### a) Read Student Records
- Read a set of **at least 10 student records**.
- Each student record should include:
  - **Employee Name**
  - **Employee ID**
  - **Salary**
- You may also create a **random record generator function**.
- **Duplicate values are allowed**.

---

#### b) Implement Merge Sort
- Use the **recursive version** of the **Merge Sort** algorithm.
- Sort records in **ascending order of names** (alphabetically).

---

#### c) Track Intermediate Progress
- After every call to the **merge procedure**, display the **partially sorted names**.
- This helps to observe how Merge Sort progresses.

---

#### d) Display Results
- Show **unsorted records** before starting the sort.
- Show **sorted records** after the algorithm completes.

---

#### e) Measure Execution Time
- Use a **built-in timer function** to measure time taken for sorting.
- In **C/C++**, you can also use the **Unix time command**:

```bash
$ vi sample.cpp        # or vi sample.c
$ c++ -o sample sample.cpp
$ time ./sample
```
OR
```bash
$ cc -o sample sample.c
$ time ./sample
```

### 🧾 Sample (If Inputs Are Just Numbers)

#### Given Array:

| 8 | 7 | 6 | 5 | 4 | 3 | 2 | 1 |
|---|---|---|---|---|---|---|---|

---

#### Intermediate Stages:

| Stage |  |      |      |      |     |     |  |  |
|-------|---|-------|----|---|---|---|---|-----------|
| 1     | 7 | **8** | 6 | 5 | 4 | 3 | 2 | 1       |
| 2     | 7 | 8 | **5** | **6** | 4 | 3 | 2 | 1       |
| 3     | **5** | **6** | **7** | **8** | 4 | 3 | 2 | 1       |
| 4     | 5 | 6 | 7 | 8 | **3** | **4** | 2 | 1       |
| 5     | 5 | 6 | 7 | 8 | 3 | 4 | **1** | **2**       |
| 6     | 5 | 6 | 7 | 8 | **1** | **2 | **3** | **4**      |
| 7     | **1** | **2** | **3** | **4** | **5** | **6** | **7** | **8**       |

---

#### Final Output (Sorted Array):

| 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
|---|---|---|---|---|---|---|---|

---

####  Notes

- The **key field for sorting** is the **Employee Name**.
- Make sure your **merge function prints** the current state of the list/array after **each merge**.
- Use appropriate **data structures** to represent employee records.

---
