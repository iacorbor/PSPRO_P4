package Controlador;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class EnvLoader {
    public static Map<String,String> loadDotenv(Path path) {
        Map<String,String> map = new HashMap<>();
        try {
            for (String rawLine : Files.readAllLines(path)) {
                String line = rawLine.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                int eq = line.indexOf('=');
                if (eq <= 0) continue;
                String key = line.substring(0, eq).trim();
                String val = line.substring(eq + 1).trim();
                if ((val.startsWith("\"") && val.endsWith("\"")) ||
                        (val.startsWith("'") && val.endsWith("'"))) {
                    val = val.substring(1, val.length()-1);
                }
                map.put(key, val);
            }
        } catch(Exception e) {
            System.out.println("Error reading .env file: " + e.getMessage());
        }
        return map;
    }
}
