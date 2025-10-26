package org.example.io;

import com.google.gson.*;
import java.io.*;

public class OutputWriter {
    public static void writeJson(String filePath, JsonObject json) throws IOException {
        try (Writer writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(json, writer);
        }
    }
}