package Vika9;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class KittenOnATree_A {
    public static void main(String[] args) {
        int kitten_branch = StdIn.readInt();

        // Creating a Symbol table to store the parents and child as keys and values, (for of each branch)
        ST<Integer, Integer> parent_tree = new ST<>();

        while (true) {
            String line = StdIn.readLine().trim();
            if (line.equals("-1")) {
                break;  
            }
            if (line.isEmpty()) {
                continue;
            }
            // Split the input line into tokens using whitespace as the delimiter
            String[] tokens = line.split("\\s+"); // Split on one or more whitespace characters
            int parent = Integer.parseInt(tokens[0]); // convert the first number from tokens, parent
            for (int i = 1; i < tokens.length; i++) {
                int child = Integer.parseInt(tokens[i]); // convert the other number from tokens, child
                parent_tree.put(child, parent); // Store that the child's parent is 'parent'
            }
        }
        int curr_branch = kitten_branch;
        while (parent_tree.contains(curr_branch)) {
            StdOut.print(curr_branch + " ");
            curr_branch = parent_tree.get(curr_branch); // get the next, or parent to our current
        }
        StdOut.println(curr_branch);
    }
}
