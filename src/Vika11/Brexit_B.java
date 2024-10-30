package Vika11;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Brexit_B {
    public static void main(String[] args) {
        int c_country_node = StdIn.readInt();
        int p_partnership_edge = StdIn.readInt();
        int x_home_country = StdIn.readInt() - 1; // for index
        int l_leaving_country = StdIn.readInt() - 1; // for index
        
        @SuppressWarnings("unchecked")
        Bag<Integer>[] graph = (Bag<Integer>[]) new Bag[c_country_node];
        int[] initialPartners = new int[c_country_node];
        int[] remainingPartners = new int[c_country_node];

        for (int i = 0; i < c_country_node; i++) {
            graph[i] = new Bag<Integer>();
        }

        // popoulate the graph according to partnerships, (adjancy list)
        for (int i = 0; i < p_partnership_edge; i++) {
            int A = StdIn.readInt() - 1;
            int B = StdIn.readInt() - 1;
            graph[A].add(B);
            graph[B].add(A);
            initialPartners[A]++;
            initialPartners[B]++;
            remainingPartners[A]++;
            remainingPartners[B]++;
        }

        // BFS queue to see what countries are leaving
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(l_leaving_country); // adds the leaving country

        boolean[] leaving_countries = new boolean[c_country_node]; 
        leaving_countries[l_leaving_country] = true;

        while (!queue.isEmpty()) {
            int country = queue.dequeue();

            // if our home country x leaves, then we leave
            if (country == x_home_country) {
                StdOut.println("leave");
                return;
            }

            // processing neighbors of the country leaving currently
            for (int neighbor : graph[country]) {
                if (!leaving_countries[neighbor]) {
                    remainingPartners[neighbor]--;

                    // check if current country/neighbor should now leave
                    if (remainingPartners[neighbor] * 2 <= initialPartners[neighbor]) {
                        leaving_countries[neighbor] = true; // add it to the leaving countries 
                        queue.enqueue(neighbor);
                    }
                }
            }
        }
        // if we finish the loop and X did not leave, we stay
        StdOut.println("stay");
    }
}
