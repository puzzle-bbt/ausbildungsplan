package controller;

import model.Plan;
import model.Semester;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Builder{


    public static void main(String[] args) throws Exception {
        SourceDataReader reader = new SourceDataReader();
        HashMap<String, ArrayList> mapYamlObjects = reader.readAndPrepareAllSourceDataYamls();

        TopicCreator topicCreator = new TopicCreator();
        Plan plan = new Plan(topicCreator.createTopics(mapYamlObjects));
        //TODO: render plan
        reader.createMasterYaml(plan);
        Plan plan1 = plan;



    }

}