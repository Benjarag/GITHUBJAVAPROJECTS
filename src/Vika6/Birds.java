package Vika6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Birds {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        
        // Read the input
        int l = io.getInt();  // Length of the wire
        int d = io.getInt();  // Minimum distance between birds
        int n = io.getInt();  // Number of birds already sitting on the wire
        
        List<Integer> birds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            birds.add(io.getInt());  // Positions of birds
        }
        
        // Sort the positions of the birds
        Collections.sort(birds);
        
        // We will calculate how many additional birds can fit
        int additionalBirds = 0;

        // Case 1: If there are no birds on the wire
        if (n == 0) {
            int usableLength = l - 12; // From position 6 to l-6
            if (usableLength >= 0) {
                additionalBirds = (usableLength / d) + 1; // +1 for the first bird at 6 cm
            }
        } else {
            // Case 2: Birds are already on the wire
            // 1. From the start of the wire (6 cm) to the first bird
            additionalBirds += (birds.get(0) - 6) / d;
            
            // 2. Between each pair of consecutive birds
            for (int i = 1; i < n; i++) {
                additionalBirds += (birds.get(i) - birds.get(i - 1)) / d - 1;
            }
            
            // 3. From the last bird to the end of the wire (l - 6 cm)
            additionalBirds += (l - 6 - birds.get(n - 1)) / d;
        }
        
        // Output the result
        io.println(additionalBirds);
        io.flush(); // Ensure output is sent to the console
        io.close(); // Clean up resources
    }
}