# Lab Exercise 5  


### Objective

Write a **C/C++/Java** program to perform the following tasks:

---

### Instructions

#### a) Initialize Array  
- Create and initialize **10,000** unique, positive, and consecutive floating-point numbers in the range [0–9999].
- Store them in **ascending order** using an iterative statement.  
Example in C:
```c
float a[10000];
for(int i = 0; i < 10000; i++) a[i] = i;
```
### b) Implement Search Algorithms

- Implement both **Linear Search (LS)** and **Binary Search (BS)**.
- For each search query, display:
  -  The **position (index)** in the array
  -  The **search time** (in microseconds)

---

### c) Functions

- Implement **LS** and **BS** as **separate functions** within the **same program**.
- Measure and compare the **time taken** by each algorithm.

---

### d) User Input

- Allow the **user to enter** the **search key value** at runtime.

---

### e) Time & Iteration Analysis

- Count and print the number of **loop iterations** in both LS and BS.
- Verify time complexity:
  - **O(N)** for Linear Search
  - **O(log₂ N)** for Binary Search
- Use the following test cases:
  - `9999` → last element (worst case for LS)
  - `50000` → not found (worst case for both)

---

### Note

If the **measured search times** are too small to distinguish:

- Increase the array size to **100,000** elements with values `[0–99999]`
- Print the **index value** being checked during each iteration for **both algorithms**

---

### Sample Input/Output

#### Linear Search

| **Input** | **Output (Index)** | **Search Time (μs)** |
|----------:|--------------------|------------------------|
| `5000`    | `5000`             | `#######`              |
| `9997`    | `9997`             | `#######`              |
| `50000`   | `Not Found (-1)`   | `#######`              |

---

#### Binary Search

| **Input** | **Output (Index)** | **Search Time (μs)** |
|----------:|--------------------|------------------------|
| `5000`    | `5000`             | `#######`              |
| `9997`    | `9997`             | `#######`              |
| `50000`   | `Not Found (-1)`   | `#######`              |

---

### Execution Tip (for C/C++)

To **compile and measure time** in a **Unix/Linux** environment:

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


