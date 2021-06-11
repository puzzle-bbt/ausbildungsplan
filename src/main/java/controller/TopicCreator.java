package controller;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class TopicCreator {
    //TODO: rework ids
    public ArrayList<Topic> createTopics(HashMap<String, ArrayList> mapYamlObjects) {
        ArrayList<TopicYaml> yamlTopics = mapYamlObjects.get("topics");
        ArrayList<CompetencyYaml> yamlCompetencies = mapYamlObjects.get("competencies");
        ArrayList<CompetencyLevelYaml> yamlCompetencyLevels = mapYamlObjects.get("levels");
        ArrayList<LevelYearCalendarWeek> levelYearCalendarWeeks = mapYamlObjects.get("levelYearCalendarWeeks");
        ArrayList<Topic> topics = new ArrayList<>();
        for (TopicYaml yamlTopic : yamlTopics) {
            Topic topic = new Topic(yamlTopic.getId(), yamlTopic.getTitle(), yamlTopic.getDescription());
            for (CompetencyYaml yamlCompetency : yamlCompetencies) {
                if (yamlCompetency.getTopic_id().equals(topic.getId())) {
                    Competency competency = new Competency(yamlCompetency.getId(), yamlCompetency.getTitle(), yamlCompetency.getDescription());
                    for (CompetencyLevelYaml yamlCompetencyLevel : yamlCompetencyLevels) {
                        if (yamlCompetencyLevel.getCompetency_id().equals(competency.getId())) {
                            for (LevelYearCalendarWeek levelYearCalendarWeek : levelYearCalendarWeeks) {
                                if (levelYearCalendarWeek.getId().equals(yamlCompetencyLevel.getId())) {
                                    competency.addCompetencyLevel(new CompetencyLevel(yamlCompetencyLevel.getId(), yamlCompetencyLevel.getInstruments(), yamlCompetencyLevel.getGoals(), levelYearCalendarWeek.getYear(), levelYearCalendarWeek.getYear_calendar_week())); //TODO
                                }
                            }
                        }
                    }
                    topic.addCompetency(competency);
                }
            }
            topics.add(topic);
        }
        return topics;
    }
}
