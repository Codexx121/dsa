import java.util.Scanner;

class BigStack {
    private char[] arr;
    private int top;
    private int capacity;

    public BigStack(int size) {
        arr = new char[size];
        capacity = size;
        top = -1;
    }

    public void push(char ch) {
        arr[++top] = ch;
    }

    public char pop() {
        return arr[top--];
    }

    public char peek() {
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;

    }
}

class BigStackInt {
    private int[] arr;
    private int top;
    private int capacity;

    public BigStackInt(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int value) {
        arr[++top] = value;
    }

    public int pop() {
        return arr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

//MAIN CLASS
public class newstack1{


    //Precedence function
    static int PrecedenceCalc(char ch) {
        switch (ch) {
            case '+': 
            case '-': 
            return 1;
            
            case '*':
            case '/': 
            return 2;
            
            default: 
            return -1;
        }
    }


    //Conversion function
    static String ToPostfixCONV(String infix) {
        StringBuilder postfix = new StringBuilder();
        BigStack stack = new BigStack(infix.length());
        
        for (char ch : infix.toCharArray()) {
            if (Character.isDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && PrecedenceCalc(stack.peek()) >= PrecedenceCalc(ch)) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        
        return postfix.toString();
    }
    
    // eval post fix
    static int CalculatePOSTFIX(String postfix) {
        BigStackInt stack = new BigStackInt(postfix.length());
        
        for (char ch : postfix.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int b = stack.pop();
                int a = stack.pop();
                
                switch (ch) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the infix expression: ");
        String infix = scanner.nextLine().replaceAll(" ", "");
        
        String postfix = ToPostfixCONV(infix);
   	System.out.println("Postfix expression is: " + postfix);
      	int finalval = CalculatePOSTFIX(postfix);
        System.out.println("Result of the evaluation: " + finalval);
        scanner.close();
    }
}
