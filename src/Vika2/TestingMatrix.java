package Vika2;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.DirectedEdge;

import edu.princeton.cs.algs4.AdjMatrixEdgeWeightedDigraph;

public class TestingMatrix {
    

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int E = 6; // Number of edges

        // Create a new edge-weighted directed graph with V vertices
        AdjMatrixEdgeWeightedDigraph graph = new AdjMatrixEdgeWeightedDigraph(V);

        // Manually add some directed edges with weights
        graph.addEdge(new DirectedEdge(0, 1, 0.5));
        graph.addEdge(new DirectedEdge(0, 2, 1.2));
        graph.addEdge(new DirectedEdge(1, 3, 0.3));
        graph.addEdge(new DirectedEdge(2, 3, 1.8));
        graph.addEdge(new DirectedEdge(3, 4, 2.5));
        graph.addEdge(new DirectedEdge(4, 0, 0.9));

        // Print the graph to standard output
        StdOut.println("Edge-weighted digraph:");
        StdOut.println(graph);

        // Iterate over the edges incident from vertex 0 and print them
        StdOut.println("Edges incident from vertex 0:");
        for (DirectedEdge e : graph.adj(0)) {
            StdOut.println(e);
        }
    }
}

