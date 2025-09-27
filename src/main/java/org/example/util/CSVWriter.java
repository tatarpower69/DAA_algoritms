package org.example.util;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    private FileWriter writer;

    public CSVWriter(String filePath) throws IOException {
        writer = new FileWriter(filePath);
    }

    public void writeLine(String line) throws IOException {
        writer.write(line + "\n");
    }

    public void writeLine(String[] values) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]);
            if (i < values.length - 1) {
                sb.append(",");
            }
        }
        sb.append("\n");
        writer.write(sb.toString());
    }

    public void close() throws IOException {
        writer.close();
    }
}
