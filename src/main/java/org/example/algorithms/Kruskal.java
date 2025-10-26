package org.example.algorithms;

import org.example.graph.*;
import org.example.util.AlgorithmResult;

import java.util.ArrayList;
import java.util.List;

public class Kruskal {
    private final KruskalMST kruskalMST;

    public Kruskal(EdgeWeightedGraph graph) {
        this.kruskalMST = new KruskalMST(graph);
    }

    public AlgorithmResult run() {
        long start = System.nanoTime();
        List<Edge> edges = new ArrayList<>();
        for (Edge e : kruskalMST.edges()) edges.add(e);
        double totalCost = kruskalMST.weight();
        int ops = kruskalMST.getOperationsCount();
        long end = System.nanoTime();
        double timeMs = (end - start) / 1e6;
        return new AlgorithmResult(edges, totalCost, ops, timeMs);
    }
}
