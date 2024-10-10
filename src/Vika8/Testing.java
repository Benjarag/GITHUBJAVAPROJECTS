package Vika8;

import java.util.HashSet;

public class Testing {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        
        int n_number_of_plotted_points = io.getInt();
        Long[][] points = new Long[n_number_of_plotted_points][2];

        for (int i = 0; i < n_number_of_plotted_points; i++) {
            points[i][0] = io.getLong();
            points[i][1] = io.getLong();
        }
        io.println(countPairs(n_number_of_plotted_points, points));
        io.close();
    }

    public static int countPairs(int n_number_of_plotted_points, Long[][] points) {
        Long length = 2018L; // given length
        Long length_squared = length * length; // square of the distance
        int counter = 0; // counter to count how many times the distance is equal to the squared one
        
        // Create a HashSet to store all points
        HashSet<String> pointSet = new HashSet<>();
        
        // Store all points as strings in the format "x,y"
        for (int i = 0; i < n_number_of_plotted_points; i++) {
            pointSet.add(points[i][0] + "," + points[i][1]);
        }
        
        // Now check each point for pairs
        for (int i = 0; i < n_number_of_plotted_points; i++) {
            Long x1 = points[i][0];
            Long y1 = points[i][1];
            
            // Check for points that would form a squared distance of length_squared
            for (Long dx = -length; dx <= length; dx++) {
                Long dy_squared = length_squared - dx * dx; // calculate dy^2
                
                if (dy_squared < 0) continue; // skip if dy^2 is negative
                
                long dy = (long) Math.sqrt(dy_squared);
                
                // Check both positive and negative dy values
                if (pointSet.contains((x1 + dx) + "," + (y1 + dy))) {
                    counter++;
                }
                if (dy != 0 && pointSet.contains((x1 + dx) + "," + (y1 - dy))) {
                    counter++;
                }
            }
        }

        return counter / 2; // Each pair is counted twice, so divide by 2
    }
}
