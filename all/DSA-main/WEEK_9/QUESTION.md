# Lab Exercise 9  

## Objective

Write a **C/C++/Java** program to implement a **Hash Table** using the **Open Addressing** method with both **Linear Probing** and **Quadratic Probing**.

---

## Instructions

- Create a **hash table** of size `MAX_SIZE` to store **strings as keys**.
- Collision Resolution:
  - **Linear Probing**
  - **Quadratic Probing**
- Each table location should indicate if it is:
  - **EMPTY**
  - **OCCUPIED**
  - **DELETED**

---

## Hash Function

Given a string, the hash value is computed as:

```
HASH VALUE = 
(sum of ASCII values of alphabets) 
+ 3*(sum of digits' ASCII values) 
+ 5*(sum of symbols' ASCII values) 
+ 7 
MOD MAX_SIZE
```

Example:  
Input String: `Az98*#`,  
MAX_SIZE = 7,  
Hash Value = `((65+122) + 3*(57+56) + 5*(42+35) +7) % 7 = 918 % 7 = 1`

---

## Operations

- **Add**: Compute and insert the string at the appropriate index using probing.
- **Search**: Find and display whether a key exists.
- **Delete**: Delete a given key and mark its slot as **DELETED**.
- **Display**: Show the full hash table with states.

---

## Sample Output Snippets

### Linear Probing

```
Enter the string to add: hello → Key hello added at index 0
Enter the string to add: world → Key world added at index 6
Enter the string to add: hashing → Key hashing added at index 3

Full Hash Table:
0: hello
1: EMPTY
2: EMPTY
3: hashing
6: world
```

### Quadratic Probing

```
Enter the string to add: hello → Key hello added at index 0
Enter the string to add: world → Key world added at index 6
Collision handled for "world", added at index 3
Enter the string to add: hashing → Collision handled and added at index 4
```

---

## Notes

- Open Addressing helps resolve collisions without chaining.
- Linear and Quadratic probing strategies demonstrate different collision behaviors.

---
