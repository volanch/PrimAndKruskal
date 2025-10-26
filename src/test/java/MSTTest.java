import org.example.io.InputReader;
import org.example.io.OutputWriter;
import org.example.graph.*;
import org.example.algorithms.*;
import org.example.util.AlgorithmResult;
import org.example.algorithms.Prim;
import com.google.gson.*;
import java.io.*;
import java.util.*;

public class MSTTest {
    public static void main(String[] args) throws IOException {
        String inputPath = "src/main/java/org/example/data/input_example.json";
        String outputPath = "src/main/java/org/example/data/output_example.json";

        JsonObject input = InputReader.readJson(inputPath);
        JsonArray graphs = input.getAsJsonArray("graphs");

        JsonArray results = new JsonArray();

        for (JsonElement gEl : graphs) {
            JsonObject gObj = gEl.getAsJsonObject();
            int id = gObj.get("id").getAsInt();

            JsonArray nodesArr = gObj.getAsJsonArray("nodes");
            List<String> nodes = new ArrayList<>();
            for (JsonElement n : nodesArr) nodes.add(n.getAsString());

            EdgeWeightedGraph graph = new EdgeWeightedGraph(nodes.size());
            Map<String, Integer> nameToIndex = new HashMap<>();
            for (int i = 0; i < nodes.size(); i++) {
                nameToIndex.put(nodes.get(i), i);
            }

            JsonArray edgesArr = gObj.getAsJsonArray("edges");
            for (JsonElement eEl : edgesArr) {
                JsonObject eObj = eEl.getAsJsonObject();
                String from = eObj.get("from").getAsString();
                String to = eObj.get("to").getAsString();
                double weight = eObj.get("weight").getAsDouble();
                graph.addEdge(new Edge(nameToIndex.get(from), nameToIndex.get(to), weight));
            }

            JsonObject graphResult = new JsonObject();
            graphResult.addProperty("graph_id", id);

            JsonObject inputStats = new JsonObject();
            inputStats.addProperty("vertices", graph.V());
            inputStats.addProperty("edges", graph.E());
            graphResult.add("input_stats", inputStats);

            Prim prim = new Prim(graph);
            AlgorithmResult primRes = prim.run();

            graphResult.add("prim", primRes.toJson(nodes));

            Kruskal kruskal = new Kruskal(graph);
            AlgorithmResult kruskalRes = kruskal.run();
            graphResult.add("kruskal", kruskalRes.toJson(nodes));

            results.add(graphResult);
        }

        JsonObject output = new JsonObject();
        output.add("results", results);
        OutputWriter.writeJson(outputPath, output);
    }
}
