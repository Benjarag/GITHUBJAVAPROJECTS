package Vika2;

import java.util.Iterator;
import java.util.LinkedList;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Lyklagangriti_F {
    public static void main(String[] args) {
        // reading in the string input
        String inputted_password = StdIn.readString();

        LinkedList<Character> password = new LinkedList<>();
        int cursor = 0; // starts in the beginning

        // iterates over characters in a CharArray from the inputted password
        for (char ch : inputted_password.toCharArray()) {
            switch (ch) {
                case 'L':
                    if (cursor > 0) cursor--; //moving cursor left
                    break;
                case 'R':
                    if (cursor < password.size()) cursor++; //moving cursor right
                    break;
                case 'B':
                    if (cursor > 0) {
                        cursor--; // cursor to left
                        password.remove(cursor); // removing at the cursor index
                    }
                    break;
                default:
                    password.add(cursor, ch); // adding at the cursor index
                    cursor++; // cursor to right
                    break;
            }
        }

        // finally you can print out the password from the CharArray using stringbuilder
        StringBuilder string = new StringBuilder();
        Iterator<?> it = password.iterator();
        
        while (it.hasNext()) {
            string.append(it.next());
        }
        StdOut.println(string);
    }
}
