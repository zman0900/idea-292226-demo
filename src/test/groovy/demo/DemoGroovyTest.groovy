package demo

import static org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ziemba.Demo

class DemoGroovyTest {
    private Demo demo


    @BeforeEach
    void setUp() {
        demo = new Demo()
    }


    @Test
    void testDemoReadResFromClass() {
        assertEquals('demo', demo.readResFromClass())
    }

    @Test
    void testDemoReadResFromClassLoader() {
        assertEquals('demo', demo.readResFromClassLoader())
    }

    @Test
    void readTestResFromClass() {
        assertEquals('test', getClass().getResource('/test-res.txt')?.text?.trim())
    }

    @Test
    void readTestResFromClassLoader() {
        assertEquals('test', getClass().getClassLoader().getResource('test-res.txt')?.text?.trim())
    }

}
