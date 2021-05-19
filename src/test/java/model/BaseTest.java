package model;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class BaseTest {

    @org.junit.jupiter.api.Test
    void getData() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("test.yaml");
        String obj = yaml.load(inputStream);
        assertEquals("test", obj);
    }
}