package org.example.algorithms;

import org.example.graph.*;
import java.util.*;

public class KruskalMST {
    private double weight;
    private final List<Edge> mst = new ArrayList<>();
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

            operationsCount += 2;
            int rootV = dsu.find(v);
            int rootW = dsu.find(w);

            operationsCount++;
            if (rootV != rootW) {
                dsu.union(rootV, rootW);
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