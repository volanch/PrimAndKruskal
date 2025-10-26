package org.example.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.example.graph.Edge;

import java.util.List;

public class AlgorithmResult {
    private final List<Edge> mstEdges;
    private final double totalCost;
    private final int operationsCount;
    private final double executionTimeMs;

    public AlgorithmResult(List<Edge> mstEdges, double totalCost, int operationsCount, double executionTimeMs) {
        this.mstEdges = mstEdges;
        this.totalCost = totalCost;
        this.operationsCount = operationsCount;
        this.executionTimeMs = executionTimeMs;
    }

    public JsonObject toJson(List<String> nodeNames) {
        JsonObject obj = new JsonObject();
        JsonArray edgesArray = new JsonArray();
        for (Edge e : mstEdges) {
            JsonObject edgeObj = new JsonObject();
            edgeObj.addProperty("from", nodeNames.get(e.either()));
            edgeObj.addProperty("to", nodeNames.get(e.other(e.either())));
            edgeObj.addProperty("weight", e.weight());
            edgesArray.add(edgeObj);
        }
        obj.add("mst_edges", edgesArray);
        obj.addProperty("total_cost", totalCost);
        obj.addProperty("operations_count", operationsCount);
        obj.addProperty("execution_time_ms", executionTimeMs);
        return obj;
    }
}
