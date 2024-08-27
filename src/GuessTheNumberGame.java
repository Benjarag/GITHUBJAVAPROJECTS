

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class GuessTheNumberGame {
    public static void main(String[] args) {

        int guess_number = StdRandom.uniformInt(1, 1001); // this will give a random number from 1 to 1000
        StdOut.println(guess_number);
        
        for (int i = 0; i < 9; i++) {
            int user_guess = StdIn.readInt();
            if (user_guess > guess_number) {
                StdOut.println("lower");
            }
            else if (user_guess < guess_number) {
                StdOut.println("higher");
            }
            else {
                StdOut.println("correct");
                break;
            }
        }
        int user_guess = StdIn.readInt();
        if (user_guess == guess_number) {
            StdOut.println("correct");
        }
    
    
    
    
    
    
    }
}
