package org.example.algorithms;

import org.example.graph.*;
import org.example.util.AlgorithmResult;

import java.util.ArrayList;
import java.util.List;

public class Kruskal {
    private final EdgeWeightedGraph graph;

    public Kruskal(EdgeWeightedGraph graph) {
        this.graph = graph;
    }

    public AlgorithmResult run() {
        // Warm-up
        for (int i = 0; i < 3; i++) new KruskalMST(graph);

        // Start timing before the actual algorithm
        long start = System.nanoTime();
        KruskalMST kruskalMST = new KruskalMST(graph);
        long end = System.nanoTime();

        List<Edge> edges = new ArrayList<>();
        for (Edge e : kruskalMST.edges()) edges.add(e);
        double totalCost = kruskalMST.weight();
        int ops = kruskalMST.getOperationsCount();
        double timeMs = (end - start) / 1e6;
        return new AlgorithmResult(edges, totalCost, ops, timeMs);
    }
}
