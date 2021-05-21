package model;

import java.util.ArrayList;
import java.util.Map;

public class Topic {
    private String id;
    private String title;
    private String description;
    public ArrayList<Compentency> compentencies;
    private ArrayList<YearCalendarWeek> yearCalendarWeeks;

    public Topic(String id, String title, String description, ArrayList<Compentency> compentencies) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.compentencies = compentencies;
        this.yearCalendarWeeks = new ArrayList<>();
    }

    public static ArrayList<Topic> getTopics(Map<String, Object> masterMap) {
        ArrayList<Map<String, Object>> topicMapList = (ArrayList<Map<String, Object>>) masterMap.get("topics");
        ArrayList<Topic> topics = new ArrayList<>();
        for (Map<String, Object> topicMap : topicMapList) {
            topics.add(createTopic(topicMap, masterMap));
        }
        return topics;
    }

    public static Topic createTopic(Map<String, Object> topicMap, Map<String, Object> masterMap) {
        ArrayList<Compentency> competencies = Compentency.getCompetencies(masterMap, topicMap.get("id").toString());
        return new Topic(topicMap.get("id").toString(), topicMap.get("title").toString(), topicMap.get("description").toString(), competencies);
    }
}
