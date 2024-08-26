package Vika0;

import java.util.Scanner;
 
public class Sith {
    public static void main(String[] args) {
        // create scanner
        Scanner scan = new Scanner(System.in);
        // scans the name, int_a, int_b and int_a_minus_b input and stores it
        scan.nextLine();
        int int_a = scan.nextInt();
        int int_b = scan.nextInt();
        int int_a_minus_b = scan.nextInt();
        // close the scanner
        scan.close();
        // calculates a-b and stores it as real_a_minus_b
        int real_a_minus_b = int_a - int_b;
        // checks if a a_minus_b and real_a_minus_b match
        if (real_a_minus_b == int_a_minus_b) {
            // check if given a_minus_b is negative or positive and prints out JEDI if negative and VEIT EKKI if positive
            if (0 < int_a_minus_b) {
                System.out.println("VEIT EKKI");
            } else {
                System.out.println("JEDI");
            }
        // if they do not match it prints out SITH
        } else {
            System.out.println("SITH");
        }
    }
}