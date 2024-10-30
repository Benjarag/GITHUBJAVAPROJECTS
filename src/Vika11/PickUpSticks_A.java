package Vika11;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.Topological;

public class PickUpSticks_A {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n_sticks = io.getInt();
        int m_lines = io.getInt();
        Digraph graph = new Digraph(n_sticks);
        for (int i = 0; i < m_lines; i++) {
            int a = io.getInt() - 1; // adjust for indexing
            int b = io.getInt() - 1; // adjust for indexing
            graph.addEdge(a, b); // add both to graph
        }
        DirectedCycle checkCycle = new DirectedCycle(graph);
        // check for cycles
        if (checkCycle.hasCycle()) { 
            io.println("IMPOSSIBLE");
            io.flush();
            return;
        }
        Topological topological = new Topological(graph);
        // we use topological for picking up sticks without conflict
        if (topological.hasOrder()) {
            for (int stick : topological.order()) {
                io.println(stick + 1); // adjusting back to 1 based indexing for output
            }
        } 
        else {
            io.println("IMPOSSIBLE");
        }
        io.flush();
    }
}
