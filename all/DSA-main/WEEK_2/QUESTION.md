# Lab Exercise 2  

### Objective

Write a **C/C++/Java** program to perform the following:

---

### Task Description

1. **Infix to Postfix Conversion and Evaluation**  
   - Convert an **infix expression** into its corresponding **postfix expression**.
   - Evaluate the generated **postfix expression**.
   - The input infix expression should be accepted **as a string** from the user.
   - The expression can contain:
     - **Operators**: `+`, `-`, `*`, `/` (integer division)
     - **Operands**: Single-digit numbers (e.g., `9+3*(7-8)+5/4`)
   - **No spaces** are allowed between characters in the expression. If spaces are present, they should be ignored.
   - Implement a **custom stack** with minimum required functionalities. Do **not** use in-built stack libraries.
   - Both **conversion and evaluation** should be implemented in the **same program**.

---

### Implementation Notes

- Input must be entered without spaces.
- If spaces are present in the input, the program must handle them gracefully (ignore).
- Postfix evaluation must be based on a standard stack-based algorithm.
- Use only arrays or structures to build the stack manually.

---

### Test Scenarios

#### Test Case 1

| **Infix Expression**     | **Postfix Expression** | **Evaluation Result** |
|--------------------------|------------------------|------------------------|
| `9+3*(7-8)+5/4`          | `9378-*+54/+`          | `7`                    |

#### Test Case 2

| **Infix Expression**        | **Postfix Expression** | **Evaluation Result** |
|-----------------------------|------------------------|------------------------|
| `(7+8)*(8-3)+6/2`           | `78+83-*62/+`          | `78`                   |

---
