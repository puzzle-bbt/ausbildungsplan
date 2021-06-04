package controller;

import model.Plan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Builder{


    public static void main(String[] args) throws IOException {
        SourceDataReader reader = new SourceDataReader();
        HashMap<String, ArrayList> mapYamlObjects = reader.readAndPrepareAllSourceDataYamls();

        TopicCreator topicCreator = new TopicCreator();
        Plan plan = new Plan(topicCreator.createTopics(mapYamlObjects));
        //TODO: render plan
        Plan plan1 = plan;



    }

}