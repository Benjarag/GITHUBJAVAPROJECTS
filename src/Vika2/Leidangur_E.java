package Vika2;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Leidangur_E {
    public static void main(String[] args) {
        // create a stack to store the string
        Stack<Character> stack = new Stack<>();

        // reading in the string input
        String inp = StdIn.readString();
        

        for (int i = 0 ; i < inp.length() ; i++) {
            char individual_str_inp = inp.charAt(i); // gets the individual char from str input
            if (individual_str_inp == '.') {
                continue; // skips iteration when there is a dot 
            }
            else if (individual_str_inp == 'p' || individual_str_inp == 'g' ||  individual_str_inp == 'o') {
                stack.push(individual_str_inp);
            }
            else if (individual_str_inp == 'P' || individual_str_inp == 'G' ||  individual_str_inp == 'O') {
                try {
                    char last_treasure = stack.pop();


                    while (Character.toUpperCase(last_treasure) != individual_str_inp) {
                        last_treasure = stack.pop();
                    }
                }
                catch (Exception e) {
                    StdOut.println("neibb");
                    return;
                }
                // if it is then continue
            }
        }
        // when the string has finished we now can count all treasures
        int p_count = 0;
        int g_count = 0;
        int o_count = 0;

        // iterating over the stack to p, g, o count occurrences
        for (Character ch : stack) {
            switch (ch) {
                case 'p':
                    p_count++;
                    break;
                case 'g':
                    g_count++;
                    break;
                case 'o':
                    o_count++;
                    break;
            }
        }

        // printing the counts
        System.out.println(p_count);
        System.out.println(g_count);
        System.out.println(o_count);

    }
}



