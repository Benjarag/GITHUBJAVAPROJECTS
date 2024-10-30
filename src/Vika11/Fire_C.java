package Vika11;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

public class Fire_C {
    private static final int[] direction_x = {1, -1, 0, 0};
    private static final int[] direction_y = {0, 0, 1, -1};
    public static void main(String[] args) {
        int n_testcases = StdIn.readInt();
        for (int test = 0; test < n_testcases; test++) {
            int w_width = StdIn.readInt();
            int h_height = StdIn.readInt();
            char[][] map_of_building = new char[h_height][w_width];
            int [][] fire_time = new int[h_height][w_width];
            int [][] escape_time = new int[h_height][w_width];
            Queue<int[]> fire_queue = new Queue<>();
            Queue<int[]> escape_queue = new Queue<>();
            int start_x = -1;
            int start_y = -1;

            // building map and time grids
            for (int i = 0; i < h_height; i++) {
                String line = StdIn.readString();
                for (int j = 0; j < w_width; j++) {
                    map_of_building[i][j] = line.charAt(j);
                    fire_time[i][j] = Integer.MAX_VALUE;
                    escape_time[i][j] = Integer.MAX_VALUE;

                    if (map_of_building[i][j] == '*') {
                        fire_queue.enqueue(new int[]{i, j}); // add * to queue
                        fire_time[i][j] = 0; // starting fire time
                    }
                    else if (map_of_building[i][j] == '@') {
                        start_x = i;
                        start_y = j;
                        escape_queue.enqueue(new int[]{i, j}); // add @ to queue
                        escape_time[i][j] = 0; // starting escape time
                    }
                }
            }
            // BFS for fire
            while (!fire_queue.isEmpty()) {
                int[] pos = fire_queue.dequeue();
                int x = pos[0];
                int y = pos[1];
                for (int direction = 0; direction < 4; direction++) {
                    int new_x = x + direction_x[direction];
                    int new_y = y + direction_y[direction];

                }
            }
            // BFS for escaping
            boolean escaped = false;
            while (!escape_queue.isEmpty() && !escaped) {
                int[] pos = escape_queue.dequeue();
                int x = pos[0], y = pos[1];

            }

        }
    }
    // check if we are within the boundaries
    private static boolean isValid(int x, int y, int height, int width) {
        return x >= 0 &&
    }

    // check if we are in an exit location
}
