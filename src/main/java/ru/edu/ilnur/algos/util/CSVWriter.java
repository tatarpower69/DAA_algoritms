package org.example.util;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    private final String filePath;

    public CSVWriter(String filePath) {
        this.filePath = filePath;
    }

    public void write(String header, String data) throws IOException {
        try (FileWriter fw = new FileWriter(filePath, true)) {
            fw.write(header + "\n");
            fw.write(data + "\n");
        }
    }
}
