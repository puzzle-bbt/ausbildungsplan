package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Compentency {
    private String id;
    private String title;
    private String description;
    public ArrayList<CompentencyLevel> compentencyLevels;

    public Compentency() {
    }

    public Compentency(String id, String title, String description, ArrayList<CompentencyLevel> compentencyLevels) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.compentencyLevels = compentencyLevels;
    }

    public static ArrayList<Compentency> getCompetencies(Map<String, Object> masterMap, String topicId) {
        ArrayList<Map<String, Object>> competencyMapList = (ArrayList<Map<String, Object>>) masterMap.get("competencies");
        ArrayList<Compentency> competencies = new ArrayList<>();

        List<Map<String, Object>>  filteredCompetencyMapList = competencyMapList.
                stream().
                filter(object -> object.get("id").toString().startsWith(topicId)).collect(Collectors.toList());
        for (Map<String, Object> competencyMap : filteredCompetencyMapList) {
            competencies.add(createCompetency(competencyMap, masterMap));
        }
        return competencies;
    }

    public static Compentency createCompetency(Map<String, Object> competencyMap, Map<String, Object> masterMap) {
        ArrayList<CompentencyLevel> compentencyLevels = CompentencyLevel.getCompetencyLevels(masterMap, competencyMap.get("id").toString());
        return new Compentency(competencyMap.get("id").toString(), competencyMap.get("title").toString(), competencyMap.get("description").toString(), compentencyLevels);
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

    public ArrayList<CompentencyLevel> getCompentencyLevels() {
        return compentencyLevels;
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

    public void setCompentencyLevels(ArrayList<CompentencyLevel> compentencyLevels) {
        this.compentencyLevels = compentencyLevels;
    }
}
