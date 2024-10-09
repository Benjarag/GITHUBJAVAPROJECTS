package Vika8;

import edu.princeton.cs.algs4.ST;

public class VreetingCard {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        
        int n_number_of_plotted_points = io.getInt();
        Point[] points = new Point[n_number_of_plotted_points];

        for (int i = 0; i < n_number_of_plotted_points; i++) {
            Long x = io.getLong();
            Long y = io.getLong();
            points[i] = new Point(x, y);
        }
        io.println(countPairs(n_number_of_plotted_points, points));
        io.close();
    }

    public static int countPairs(int n_number_of_plotted_points, Point[] points) {
        int length = 2018; // given length
        int counter = 0; // counter to count how many times the distance is equal to the squared one
        
        // Using ST to keep track of point occurrences
        ST<Point, Integer> pointMap = new ST<>();
        
        // Storing points in the map
        for (Point point : points) {
            Integer count = pointMap.get(point);
            if (count == null) {
                pointMap.put(point, 1); // If not present, initialize count to 1
            } else {
                pointMap.put(point, count + 1); // Increment existing count
            }
        }
        
        // Now checking for pairs
        for (Point point : points) {
            Long x = point.x;
            Long y = point.y;
            
            // Check all four possible target points
            Point[] targets = {
                new Point(x + (long) length, y),
                new Point(x - (long) length, y),
                new Point(x, y + (long) length),
                new Point(x, y - (long) length)
            };
            
            // Count pairs
            for (Point target : targets) {
                Integer targetCount = pointMap.get(target);
                if (targetCount != null) {
                    counter += targetCount;
                }
            }
        }
        
        // Each pair is counted twice, so divide the count by 2
        return counter / 2;
    }
}
