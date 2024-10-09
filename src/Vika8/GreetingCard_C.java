package Vika8;

public class GreetingCard_C {
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
        int length = 2018; // given length
        int length_squared = length * length; // square of the distance
        int counter = 0; // counter to count how many times the distance is equal to the squared one
        // iterating through each pair of points
        for (int i = 0; i < n_number_of_plotted_points; i++) {
            for (int j = i + 1; j < n_number_of_plotted_points; j++) { // int = i + 1, to aviod counting twice
                Long dx = points[i][0] - points[j][0];
                Long dy = points[i][1] - points[j][1];
                if (dx * dx + dy * dy == length_squared) {
                    counter++;
                }
            }
        }
        return counter;
    }
}