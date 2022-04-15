package ziemba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Demo {

    public String readResFromClass() {
        return toString(Objects.requireNonNull(getClass().getResourceAsStream("/main-res.txt"),
                "Failed to open resource"));
    }

    public String readResFromClassLoader() {
        return toString(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("main-res.txt"),
                "Failed to open resource"));
    }


    private String toString(final InputStream stream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            return reader.readLine();
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read", e);
        }
    }

}
