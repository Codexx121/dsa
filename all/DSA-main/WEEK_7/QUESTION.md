# Lab Exercise 7  

## Objective

Write a **C/C++/Java** program to perform the following:

Implement **Quick-Sort** recursively to sort student records based on their **CGPA**.

---

## Instructions

- Read a set of **at least 10 student records**.
- Each record should contain:
  - **Student Name**
  - **Student ID**
  - **CGPA**
- Random record generator function may be used.
- **Duplicate values are allowed**.

---

## Quick-Sort Algorithm

- Implement the **recursive version** of Quick Sort.
- Sort the records in **ascending order of CGPA**.

---

## Intermediate Display

- After every **partition procedure**, display the **partially sorted array**.
- Observe the sorting progress.

---

## Display Results

- Show the **unsorted records** before starting the sort.
- Show the **sorted records** after completing the sort.

---

## Measure Execution Time

- Use **built-in timer functions** to measure sorting time.

Example (Unix/Linux):
```bash
$ vi sample.cpp      # or vi sample.c
$ c++ -o sample sample.cpp
$ time ./sample
```
OR
```bash
$ cc -o sample sample.c
$ time ./sample
```

---

## Sample Example (If Inputs Are Integers)

### Original Array
```
20 70 10 30 50 60 40
```

---

### Intermediate Stages

- **Pivot: 40**
  ```
  20 10 30 40 50 60 70
  ```

- **Pivot: 30**
  ```
  20 10 30 40 50 60 70
  ```

- **Pivot: 10**
  ```
  10 20 30 40 50 60 70
  ```

- **Pivot: 70**
  ```
  10 20 30 40 50 60 70
  ```

- **Pivot: 60**
  ```
  10 20 30 40 50 60 70
  ```

---

### Final Sorted Array
```
10 20 30 40 50 60 70
```

---

## Notes

- Quick Sort is efficient with **average time complexity O(n log n)**.
- Proper choice of pivot and partitioning improves performance.

---
