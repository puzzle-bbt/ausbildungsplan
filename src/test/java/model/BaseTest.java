package model;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

//TODO: implement real tests

@RunWith(MockitoJUnitRunner.class)
class BaseTest {

    @org.junit.jupiter.api.Test
    void getData() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("test.yaml");
        Map<String, Object> masterYAML= yaml.load(inputStream);
        assertEquals("a drop of golden sun", masterYAML.get("ray"));
        Map<String, Object> testObj = (Map<String, Object>) masterYAML.get("doe");
        assertEquals("four", testObj.get("calling-birds"));
    }

    @org.junit.jupiter.api.Test
    void debugFind() throws Exception {
        String id = "1.1";
        Compentency comp = new Compentency("1", "test", "test_description");
        ArrayList<Map<String, String>> objects = (ArrayList<Map<String, String>>) comp.getData().get(comp.plural());
        Map<String, String> typeBlba = objects.stream().filter(o -> id.equals(o.get("id"))).findAny().orElse(null);
        comp.find("1.1");
    }
}