package Vika2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Kattis problem: Lifting walls
public class Walls {

    // Return how many distinct numbers appear (all numbers in the range 0...n-1)
    public static int ndiff(int i, int j, int k, int m, int n) {
        boolean[] in = new boolean[n];
        in[i] = in[j] = in[k] = in[m] = true;
        int ctr = 0;
        for (int z=0; z < n; z++)
          if (in[z]) ctr++;
        return ctr;        
    }

    public static void main(String[] args) {
/*        int xx = 3;
        for (int i=0; i < xx; i++)
          for (int j=0; j < xx; j++)
            StdOut.println("i: "+i+" j: "+j + " -- "+ ndiff(i,j,0,0,3));
        return;
*/
            int ell = StdIn.readInt(), w = StdIn.readInt(), n = StdIn.readInt(), r = StdIn.readInt();
        int[] x = new int[n], y = new int[n];
        for (int i=0; i < n; i++) { x[i] = StdIn.readInt(); y[i] = StdIn.readInt(); }


        double[] ctrx = new double[4], ctry = new double[4];
        ctrx[0] = -ell/2; ctrx[1] = ell/2; ctry[0] = ctry[1] = 0;
        ctry[2] = -w/2; ctry[3] = w/2; ctrx[2] = ctrx[3] = 0;
        // Compute coverage matrix: Which walls does which crane reach
        boolean[][] cov = new boolean[n][4];
        for (int i=0; i < n; i++)
          for (int j=0; j < 4; j++) {
            double d2 = (x[i]-ctrx[j])*(x[i]-ctrx[j]) + (y[i]-ctry[j])*(y[i]-ctry[j]);
            cov[i][j] = (d2 <= r*r);
          }
        // Debugging
        //  for (int i=0; i < n; i++)
        //    StdOut.println(cov[i][0] + " - " + cov[i][1] + " - " + cov[i][2] + " - " + cov[i][3]);

        // Compute cheapest solution
        int min = n+1;
        for (int i=0; i < n; i++)
            if (cov[i][0])       
                for (int j=0; j < n; j++)
                    if (cov[j][1])       
                        for (int k=0; k < n; k++)
                            if (cov[k][2])       
                                for (int m=0; m < n; m++) 
                                    if (cov[m][3]) {      
                                        // Count how many i,j,k,m are different
                                        int diffs = ndiff(i,j,k,m,n);
                                        if (diffs < min) 
                                          min = diffs;
                                    }

        if (min >= n+1)
          StdOut.println("Impossible");
        else
          StdOut.println(min);

              }

}
