package demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ziemba.Demo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

class DemoJavaTest {
    private Demo demo;


    @BeforeEach
    void setUp() {
        demo = new Demo();
    }


    @Test
    void testDemoReadResFromClass() {
        assertEquals("demo", demo.readResFromClass());
    }

    @Test
    void testDemoReadResFromClassLoader() {
        assertEquals("demo", demo.readResFromClassLoader());
    }

    @Test
    void readTestResFromClass() throws IOException {
        try (InputStream stream = Objects.requireNonNull(getClass()
                .getResourceAsStream("/test-res.txt"), "Failed to open resource")) {
            // readNBytes requires Java 11
            assertEquals("test", new String(stream.readNBytes(4), StandardCharsets.UTF_8));
        }
    }

    @Test
    void readTestResFromClassLoader() throws IOException {
        try (InputStream stream = Objects.requireNonNull(getClass().getClassLoader()
                .getResourceAsStream("test-res.txt"), "Failed to open resource")) {
            // readNBytes requires Java 11
            assertEquals("test", new String(stream.readNBytes(4), StandardCharsets.UTF_8));
        }
    }

}
