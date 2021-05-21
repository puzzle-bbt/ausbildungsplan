package model;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

public class Plan {
    ArrayList<Topic> topics;

    public Plan() {
        createPlan();
    }


    public void createPlan() {
        Map<String, Object> masterMap = getData();
        this.topics = Topic.getTopics(masterMap);
    }

    private Map<String, Object> getData() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("master.yaml");
        return yaml.load(inputStream);
    }

    public ArrayList<Topic> getTopics() {
        return topics;
    }
}
