import java.util.Scanner;


public class LeggjaSaman {
    public static void main(String[] args) {

        // create scanner
        Scanner scan = new Scanner(System.in);
        // scans the line of integer inputs and stores it in string input 1 and 2
        int num_1 = scan.nextInt();
        int num_2 = scan.nextInt();
        
        // calculates the total sum of 1 and 2 and stores it in total_sum
        int total_sum = num_1 + num_2;
        // closes the scanner
        scan.close();
        
        // prints the outcome
        System.out.println(total_sum);

    }
}
