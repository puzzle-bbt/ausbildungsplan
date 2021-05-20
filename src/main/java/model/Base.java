package model;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;


public abstract class Base {

    public String plural() throws Exception {
        throw new Exception("No plural set on this model");
    }

    public Map<String, String> all() throws Exception {
        return (Map<String, String>) getData().get(plural());
    }

    public Map<String, String> find(String id) throws Exception {
        ArrayList<Map<String, String>> objects = (ArrayList<Map<String, String>>) getData().get(plural());
        return objects.stream().filter(o -> id.equals(o.get("id"))).findAny().orElse(null);
    }

    public Map<String, Object> getData() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("master.yaml");
        return yaml.load(inputStream);
    }
}
