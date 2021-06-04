package controller;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class TopicCreator {
    //TODO: rework ids
    public ArrayList<Topic> createTopics(HashMap<String, ArrayList> mapYamlObjects) {
        ArrayList<TopicYaml> yamlTopics = mapYamlObjects.get("topics");
        ArrayList<CompentencyYaml> yamlCompetencies = mapYamlObjects.get("competencies");
        ArrayList<CompentencyLevelYaml> yamlCompetencyLevels = mapYamlObjects.get("levels");
        ArrayList<Topic> topics = new ArrayList<>();
        for(TopicYaml yamlTopic : yamlTopics){
            Topic topic = new Topic(yamlTopic.getId(), yamlTopic.getTitle(), yamlTopic.getDescription());
            for(CompentencyYaml yamlCompetency : yamlCompetencies){
                if(yamlCompetency.getTopic_id().equals(topic.getId())){
                    Compentency compentency = new Compentency(yamlCompetency.getId(), yamlCompetency.getTitle(), yamlCompetency.getDescription());
                    for (CompentencyLevelYaml yamlCompetencyLevel: yamlCompetencyLevels){
                        if(yamlCompetencyLevel.getCompetency_id().equals(compentency.getId())){
                            compentency.addCompetencyLevel(new CompentencyLevel(yamlCompetencyLevel.getId(), yamlCompetencyLevel.getInstruments(), yamlCompetencyLevel.getGoals()));
                        }
                    }
                    topic.addCompetency(compentency);
                }
            }
            topics.add(topic);
        }
        return topics;
    }
}
