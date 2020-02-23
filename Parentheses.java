import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {
    // Return true if s has matching parentheses, and false otherwise.
    private static boolean match(String s) {

        Stack<Character> stack = new Stack<Character>();    //initialize stack
        char[] oBrackets = {'{','(','['};
        char[] cBrackets = {'}',')',']'};

        int length = s.length();
        boolean isValid = true;
        for(int i = 0; i < length; i++) {
            char current = s.charAt(i);
            //determine character index
            int index = -1;
            for(int j = 0; j < oBrackets.length; j++) {
                if(oBrackets[j] == current) {
                    index = j;
                }
            }
            //if part of open bracket, push
            if(index > -1) {
                stack.push(current);
            } else {
                char topOfStack = !stack.isEmpty() ? stack.peek() : '#';
                //else assume valid character and check against index
                switch(current) {
                    case '}':
                        isValid = topOfStack == oBrackets[0];
                        break;
                    case ')':
                        isValid = topOfStack == oBrackets[1];
                        break;
                    case ']':
                        isValid = topOfStack == oBrackets[2];
                        break;
                    default:
                        isValid = false;
                        break;
                }
                if(!stack.isEmpty()) {
                    stack.pop();
                }
                if(!isValid) {
                    break;
                }
            }
        }
        return isValid && stack.isEmpty();
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        StdOut.println(match(StdIn.readAll().trim()));
    }
}