package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompentencyLevel{
    private String id;
    private ArrayList<String> instruments;
    private ArrayList<String> goals;
    private String level;

    public CompentencyLevel() {
    }

    public CompentencyLevel(String id, ArrayList<String> instruments, ArrayList<String> goals) {
        this.id = id;
        this.instruments = instruments;
        this.goals = goals;
        this.level = id.split("[.]")[2];
    }

    public static ArrayList<CompentencyLevel> getCompetencyLevels(Map<String, Object> masterMap, String competencyId) {
        ArrayList<Map<String, Object>> comptencyLevelMapList = (ArrayList<Map<String, Object>>) masterMap.get("competency_levels");
        ArrayList<CompentencyLevel> competencyLevels = new ArrayList<>();

        List<Map<String, Object>> filteredCompetencyLevelMapList = comptencyLevelMapList.
                stream().
                filter(object -> object.get("id").toString().startsWith(competencyId)).collect(Collectors.toList());
        for (Map<String, Object> competencyLevelMap : filteredCompetencyLevelMapList) {
            competencyLevels.add(createCompetencyLevel(competencyLevelMap));
        }
        return competencyLevels;
    }


    public static CompentencyLevel createCompetencyLevel(Map<String, Object> competencyLevelMap){
        return new CompentencyLevel(competencyLevelMap.get("id").toString(), (ArrayList<String>) competencyLevelMap.get("instruments"),  (ArrayList<String>) competencyLevelMap.get("goals"));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getInstruments() {
        return instruments;
    }

    public void setInstruments(ArrayList<String> instruments) {
        this.instruments = instruments;
    }

    public ArrayList<String> getGoals() {
        return goals;
    }

    public void setGoals(ArrayList<String> goals) {
        this.goals = goals;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
