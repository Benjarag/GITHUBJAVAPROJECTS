package Vika1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BestaGjofin {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        // To consume the newline after the integer input (crucial!)
        StdIn.readLine(); 


        int highest_number = Integer.MIN_VALUE;
        String highest_name = "";


       
        for (int i=0; i < n; i++) {
            // reading the whole input
            String input = StdIn.readLine();
            // splitting to get name and number
            String[] parts_name_n_number = input.split(" ");
            // getting the number
            int number = Integer.parseInt(parts_name_n_number[1]);
            // checking if its the highest number
            // and sets a new highest name
            // if it finds a higher number then then what is already
            if (highest_number < number) {
                highest_number = number;
                highest_name = parts_name_n_number[0];
            }
        }
        // prints the highest name
        StdOut.println(highest_name);
    }
}


// Forritið fyrir neðan er með sömu virkni en er gert án algs4 pakkanum

// import java.util.Scanner;


// public class BestaGjofin {
//     public static void main(String[] args) {
//         Scanner scan = new Scanner(System.in);

//         int n = scan.nextInt();
//         // To consume the newline after the integer input (crucial!)
//         scan.nextLine(); 


//         int highest_number = Integer.MIN_VALUE;
//         String highest_name = "";


       
//         for (int i=0; i < n; i++) {
//             // reading the whole input
//             String input = scan.nextLine();
//             // splitting to get name and number
//             String[] parts_name_n_number = input.split(" ");
//             // getting the number
//             int number = Integer.parseInt(parts_name_n_number[1]);
//             // checking if its the highest number
//             // and sets a new highest name
//             // if it finds a higher number then then what is already
//             if (highest_number < number) {
//                 highest_number = number;
//                 highest_name = parts_name_n_number[0];
//             }
//         }
//         // prints the highest name
//         System.out.println(highest_name);
//     }
// }