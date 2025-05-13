import java.util.Scanner;

class Stack {
    private int top;
    private int capacity;
    private char[] array;

    public Stack(int size) {
        capacity = size;
        top = -1;
        array = new char[capacity];
    }

    public void push(char x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        array[++top] = x;
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return '\0';
        }
        return array[top--];
    }

    public char peek() {
        if (isEmpty()) {
            return '\0';
        }
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}

// Main class
public class InfixToPostfix {
    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack stack = new Stack(infix.length());

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            // Skip spaces
            if (c == ' ') {
                continue;
            }

            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression"; // Invalid expression
                } else {
                    stack.pop();
                }
            }
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression"; // Invalid expression
            }
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static int evaluatePostfix(String postfix) {
        Stack stack = new Stack(postfix.length());

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isDigit(c)) {
                stack.push((char) (c - '0'));
            }
            else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push((char) (operand1 + operand2));
                        break;
                    case '-':
                        stack.push((char) (operand1 - operand2));
                        break;
                    case '*':
                        stack.push((char) (operand1 * operand2));
                        break;
                    case '/':
                        stack.push((char) (operand1 / operand2));
                        break;
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the infix expression: ");
        String infix = scanner.nextLine();

        String postfix = infixToPostfix(infix);
        System.out.println("Postfix expression is: " + postfix);

        int result = evaluatePostfix(postfix);
        System.out.println("Result of the evaluation: " + result);

    }
}
