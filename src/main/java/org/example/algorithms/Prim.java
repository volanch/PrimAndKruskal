package org.example.algorithms;

import org.example.graph.*;
import org.example.util.AlgorithmResult;

import java.util.ArrayList;
import java.util.List;

public class Prim {
    private final EdgeWeightedGraph graph;

    public Prim(EdgeWeightedGraph graph) {
        this.graph = graph;
    }

    public AlgorithmResult run() {
        // Warm-up
        for (int i = 0; i < 3; i++) new PrimMST(graph);

        // Start timing before the actual algorithm
        long start = System.nanoTime();
        PrimMST primMST = new PrimMST(graph);
        long end = System.nanoTime();

        List<Edge> edges = new ArrayList<>();
        for (Edge e : primMST.edges()) edges.add(e);
        double totalCost = primMST.weight();
        int ops = primMST.getOperationsCount();
        double timeMs = (end - start) / 1e6;
        return new AlgorithmResult(edges, totalCost, ops, timeMs);
    }
}

