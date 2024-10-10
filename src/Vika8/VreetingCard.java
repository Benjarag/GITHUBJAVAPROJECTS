package Vika8;

public class VreetingCard {
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

    public static Long countPairs(int n_number_of_plotted_points, Long[][] points) {
        int length = 2018; // given length
        int length_squared = length * length; // square of the distance
        Long counter = 0L; // counter to count how many times the distance is equal to the squared one
        
        // iterating through each pair of points
        for (int i = 0; i < n_number_of_plotted_points; i++) {
            for (int j = i + 1; j < n_number_of_plotted_points; j++) { // i + 1 to avoid counting twice
                Long dx = points[i][0] - points[j][0];
                Long dy = points[i][1] - points[j][1];
                
                // calculating the squared distance
                Long squared_distance = dx * dx + dy * dy;
                
                // // debugging, print the points and squared distance
                // System.out.printf("Comparing points (%d, %d) and (%d, %d): dx = %d, dy = %d, squared_distance = %d%n", 
                //                   points[i][0], points[i][1], points[j][0], points[j][1], dx, dy, squared_distance);
                
                // checking if the squared equals to the required length squared
                if (squared_distance == length_squared) {
                    counter++;
                }
            }
        }
        return counter;
    }
}