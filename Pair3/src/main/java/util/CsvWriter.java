package util;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class CsvWriter implements AutoCloseable {
    private final FileWriter out;

    public CsvWriter(String file) throws IOException {
        Path p = Path.of(file);
        Files.createDirectories(p.getParent());
        this.out = new FileWriter(file, true);
    }

    public void writeHeaderIfEmpty(String header) throws IOException {
        out.flush();
        out.write(header);
        out.write("\n");
        out.flush();
    }

    public void writeRow(String line) throws IOException {
        out.write(line);
        out.write("\n");
        out.flush();
    }

    @Override public void close() throws IOException {
        out.close();
    }
}