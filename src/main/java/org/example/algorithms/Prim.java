package org.example.algorithms;

import org.example.graph.*;
import org.example.util.AlgorithmResult;

import java.util.ArrayList;
import java.util.List;

public class Prim {
    private final PrimMST primMST;

    public Prim(EdgeWeightedGraph graph) {
        this.primMST = new PrimMST(graph);
    }

    public AlgorithmResult run() {
        long start = System.nanoTime();
        List<Edge> edges = new ArrayList<>();
        for (Edge e : primMST.edges()) edges.add(e);
        double totalCost = primMST.weight();
        int ops = primMST.getOperationsCount();
        long end = System.nanoTime();
        double timeMs = (end - start) / 1e6;
        return new AlgorithmResult(edges, totalCost, ops, timeMs);
    }
}

