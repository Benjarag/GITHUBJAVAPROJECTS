package Vika2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LaegdYfirLandinu_A {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int m = StdIn.readInt();

        // 2D integer array with n rows and m columns 
        int[][] integer2DArray = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                integer2DArray[i][j] = StdIn.readInt();
            }
        }

        boolean lægð = false;
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                if (checkNeighbors(integer2DArray, i, j)) {
                    lægð = true;
                    break;
                }
            }
            if (lægð)
                break;
        }
        
        // result/output
        if (lægð) StdOut.println("jebb");
        else StdOut.println("Neibb");

    }

    private static boolean checkNeighbors(int[][] array, int row, int column) {
        int n = array.length;    // Number of rows
        int m = array[0].length; // Number of columns
        int currentPressurePoint = array[row][column];
        // check cell above
        if (row > 0 && currentPressurePoint >= array[row-1][column]) return false; 
        // check cell below
        if (row < n-1 && currentPressurePoint >= array[row+1][column]) return false;
        // check left cell
        if (column > 0 && currentPressurePoint >= array[row][column-1]) return false;
        // check right cell
        if (column < m-1 && currentPressurePoint >= array[row][column+1]) return false;
        // if no neighbour has lower pressure
        return true;
    }
        
}





