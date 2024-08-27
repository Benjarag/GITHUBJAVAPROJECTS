package Vika2;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BracketMatching {
    public static void main(String[] args) {
        // the length of the bracket_string
        int n = StdIn.readInt();

        // create a stack to store the brackets
        Stack<Character> stack = new Stack<>();

        // reading in the string brackets
        String bracket_string = StdIn.readString();
        
        // if n is odd, we do not have matching brackets, thus invalid
        if (n % 2 != 0) {
            StdOut.println("Invalid");
            return;
        }

        for (int i = 0; i < n; i++) {
            char bracket = bracket_string.charAt(i); // gets the individual bracket from the string

            // push opening brackets onto the stack
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } 
            // for closing brackets, check the stack if its empty, then invalid
            else if (bracket == ')' || bracket == ']' || bracket == '}') {
                if (stack.isEmpty()) {
                    StdOut.println("Invalid");
                    return;
                }
                char last = stack.pop(); // we pop the last in stack e.g. [, {, (
                // now bracket is: ), ], }
                if (!isMatchingPair(last, bracket)) {
                    StdOut.println("Invalid");
                    return; // returns invalid if the popped char did no match with bracket
                }
            }
        }

        // if the stack is now empty, all brackets matched correctly
        if (stack.isEmpty()) {
            StdOut.println("Valid");
        } 
        // and if not, its invalid
        else {
            StdOut.println("Invalid");
        }
    }

    // help function to check if we have matching brackets
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}