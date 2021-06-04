package model;

import java.util.ArrayList;
import java.util.Map;

public class Topic {
    private String id;
    private String title;
    private String description;
    public ArrayList<Compentency> compentencies;
    private ArrayList<YearCalendarWeek> yearCalendarWeeks;

    public Topic() {
    }

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

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Compentency> getCompentencies() {
        return compentencies;
    }

    public ArrayList<YearCalendarWeek> getYearCalendarWeeks() {
        return yearCalendarWeeks;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompentencies(ArrayList<Compentency> compentencies) {
        this.compentencies = compentencies;
    }

    public void setYearCalendarWeeks(ArrayList<YearCalendarWeek> yearCalendarWeeks) {
        this.yearCalendarWeeks = yearCalendarWeeks;
    }
}
