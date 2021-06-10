package controller;

import model.Plan;

import java.util.ArrayList;
import java.util.HashMap;

public class Builder{

    private static final String FILE_PATH_YAMLS_TO_PROCESS = "src/main/resources/data";

    public static void main(String[] args) throws Exception {
        SourceDataReader reader = new SourceDataReader();
        HashMap<String, ArrayList> mapYamlObjects = reader.readAndPrepareAllSourceDataYamls(FILE_PATH_YAMLS_TO_PROCESS);

        TopicCreator topicCreator = new TopicCreator();
        Plan plan = new Plan(topicCreator.createTopics(mapYamlObjects), reader.getSemester());
        //TODO: render plan
        reader.createMasterYaml(plan);



    }

}