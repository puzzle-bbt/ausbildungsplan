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

}
