package org.example.algorithms;

import org.example.graph.*;
import java.util.*;
import java.util.Queue;

public class KruskalMST {
    private double weight;
    private Queue<Edge> mst = new LinkedList<>();
    private int operationsCount = 0;

    public KruskalMST(EdgeWeightedGraph G) {
        Edge[] edges = new Edge[G.E()];
        int t = 0;
        for (Edge e : G.edges()) {
            edges[t++] = e;
        }
        Arrays.sort(edges);

        DSU dsu = new DSU(G.V());
        for (int i = 0; i < G.E() && mst.size() < G.V() - 1; i++) {
            Edge e = edges[i];
            int v = e.either();
            int w = e.other(v);
            operationsCount++;

            if (dsu.find(v) != dsu.find(w)) {
                dsu.union(v, w);
                operationsCount++;
                mst.add(e);
                weight += e.weight();
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return weight;
    }

    public int getOperationsCount() {
        return operationsCount;
    }
}