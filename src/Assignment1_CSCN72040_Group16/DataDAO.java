package Assignment1_CSCN72040_Group16;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class DataDAO {

    public List<Data> readDataFromFile(String filePath) {
        try {
            return Files.lines(Paths.get(filePath))
                        .map(this::parseLine)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    private Data parseLine(String line) {
        String[] values = line.split(",");
        
        try {
            double x = Double.parseDouble(values[0]);
            double y = Double.parseDouble(values[1]);
            double z = Double.parseDouble(values[2]);
            int position = (values.length == 4) ? Integer.parseInt(values[3]) : -1; // Default position for 3-value lines

            return new Data(position, x, y, z);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Skipping invalid line: " + line);
            return null;
        }
    }
}
