# Lab Exercise 8  

## Objective

Write a **C/C++/Java** program to implement a **Hash Table** using **Separate Chaining** with linked lists.

---

## Instructions

- Create a **hash table** of size `MAX_SIZE` to store **strings as keys**.
- Handle collisions using **Separate Chaining**:
  - Each hash table index points to a **linked list**.
- Strings may contain:
  - English alphabets (uppercase and lowercase)
  - Digits
  - Special symbols (`#`, `$`, `*`, etc.)

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
Hash Value = `((65+122) + 3*(57+56) + 5*(42+35) +7) % 7 = 918 % 7 = 6`

---

## Operations

- **Insert**: Compute the hash and insert into corresponding chain (linked list).
- **Display**: Show all chains for each index.
- **Search**: Find a key in the hash table and display outcome.
- **Delete**: Remove a key and update the chain.

---

## Test Scenario

**Input Strings:**

```
M2y N3x F4w O5v D*2u A2t K5#y M6z N7a Y3w
b2Y e3X f4W c5V d2U a2T J5Y m6%Z n7A y3W
```

---

### Sample Hash Values

| String | Hash Value |
|--------|------------|
| M2y    | 5          |
| N3x    | 1          |
| F4w    | 2          |
| O5v    | 6          |
| D2u    | 6          |
| A2t    | 2          |
| K5y    | 5          |
| M6z    | 4          |
| N7a    | 4          |
| Y3w    | 4          |
| b2Y    | 1          |
| e3X    | 6          |
| f4W    | 2          |
| c5V    | 1          |
| d2U    | 6          |
| a2T    | 2          |
| J5Y    | 0          |
| m6Z    | 4          |
| n7A    | 4          |
| y3W    | 4          |

---

### Sample Hash Table After Insertion

```
[0]: -> m6%Z -> J5Y
[1]: -> c5V -> b2Y -> N3x
[2]: -> a2T -> f4W -> A2t -> F4w
[3]: 
[4]: -> y3W -> n7A -> Y3w -> N7a -> M6z
[5]: -> K5#y -> M2y
[6]: -> d2U -> e3X -> D*2u -> O5v
```

---

### Sample Operations

- **Delete**:  
  Delete `b2Y`
  ```
  [1]: -> c5V -> N3x
  ```

- **Search**:  
  Search `a2T` → **Key found at index 2**  
  Search `wew423` → **Key not found**

---

## Notes

- Separate chaining prevents clustering problems of open addressing.
- Linked list allows multiple keys at the same index neatly.

---
