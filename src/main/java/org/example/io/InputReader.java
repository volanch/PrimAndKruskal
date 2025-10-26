package org.example.io;

import com.google.gson.*;
import java.io.*;

public class InputReader {
    public static JsonObject readJson(String filePath) throws IOException {
        try (Reader reader = new FileReader(filePath)) {
            return JsonParser.parseReader(reader).getAsJsonObject();
        }
    }
}
