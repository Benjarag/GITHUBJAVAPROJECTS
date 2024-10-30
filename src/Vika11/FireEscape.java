package Vika11;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FireEscape {
    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};

    public static void main(String[] args) {
        int testCases = StdIn.readInt();
        for (int t = 0; t < testCases; t++) {
            int width = StdIn.readInt();
            int height = StdIn.readInt();
            char[][] buildingMap = new char[height][width];
            int[][] fireTime = new int[height][width];
            int[][] playerTime = new int[height][width];
            Queue<int[]> fireQueue = new Queue<>();
            Queue<int[]> playerQueue = new Queue<>();
            int startX = -1;
            int startY = -1;

            // Initialize the building map and time grids
            for (int i = 0; i < height; i++) {
                String line = StdIn.readString();
                for (int j = 0; j < width; j++) {
                    buildingMap[i][j] = line.charAt(j);
                    fireTime[i][j] = Integer.MAX_VALUE;  // Infinite time for cells not yet on fire
                    playerTime[i][j] = Integer.MAX_VALUE; // Infinite time for cells not yet reached by player

                    if (buildingMap[i][j] == '*') {
                        fireQueue.enqueue(new int[]{i, j});
                        fireTime[i][j] = 0; // Fire starts here at time 0
                    } else if (buildingMap[i][j] == '@') {
                        startX = i;
                        startY = j;
                        playerQueue.enqueue(new int[]{i, j});
                        playerTime[i][j] = 0; // Player starts here at time 0
                    }
                }
            }

            // BFS for fire spread
            while (!fireQueue.isEmpty()) {
                int[] pos = fireQueue.dequeue();
                int x = pos[0], y = pos[1];
                for (int d = 0; d < 4; d++) {
                    int nx = x + DX[d];
                    int ny = y + DY[d];
                    if (isValid(nx, ny, height, width) && buildingMap[nx][ny] == '.' && fireTime[nx][ny] == Integer.MAX_VALUE) {
                        fireTime[nx][ny] = fireTime[x][y] + 1;
                        fireQueue.enqueue(new int[]{nx, ny});
                    }
                }
            }

            // BFS for player movement
            boolean escaped = false;
            while (!playerQueue.isEmpty() && !escaped) {
                int[] pos = playerQueue.dequeue();
                int x = pos[0], y = pos[1];

                // Check if player is at an exit (boundary cell)
                if (isExit(x, y, height, width)) {
                    StdOut.println(playerTime[x][y]+1);
                    escaped = true;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = x + DX[d];
                    int ny = y + DY[d];
                    if (isValid(nx, ny, height, width) && buildingMap[nx][ny] == '.' &&
                            playerTime[nx][ny] == Integer.MAX_VALUE &&
                            playerTime[x][y] + 1 < fireTime[nx][ny]) {
                        playerTime[nx][ny] = playerTime[x][y] + 1;
                        playerQueue.enqueue(new int[]{nx, ny});
                    }
                }
            }

            // If player did not escape
            if (!escaped) {
                StdOut.println("IMPOSSIBLE");
            }
        }
    }

    // Check if cell is within the boundaries of the map
    private static boolean isValid(int x, int y, int height, int width) {
        return x >= 0 && x < height && y >= 0 && y < width;
    }

    // Check if cell is an exit (on the edge of the map)
    private static boolean isExit(int x, int y, int height, int width) {
        return x == 0 || x == height - 1 || y == 0 || y == width - 1;
    }
}
