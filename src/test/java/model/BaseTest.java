package model;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

//TODO: implement real tests

@RunWith(MockitoJUnitRunner.class)
class BaseTest {

    @org.junit.jupiter.api.Test
    void getPlan() {
        Plan plan = new Plan();
        assertNotEquals(plan, null);
    }

}