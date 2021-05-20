package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Topic extends Base {
    private String id;
    private String title;
    private String description;
    public ArrayList<Compentency> compentencies;
    private ArrayList<YearCalendarWeek> yearCalendarWeeks;

    public Topic(String id, String title, String description, ArrayList<YearCalendarWeek> yearCalendarWeeks) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.compentencies = new ArrayList<>();
        this.yearCalendarWeeks = yearCalendarWeeks;
    }

    public void getCompetencies(Topic this) throws Exception {
        ArrayList<Map<String, String>> competencies = (ArrayList<Map<String, String>>) this.getData().get("competencies");

        List<Map<String, String>> filteredCompetencies = competencies.
                stream().
                filter(object -> id.equals(object.get("id").split("[.]")[0])).collect(Collectors.toList());
        for (Map<String, String> map : filteredCompetencies) {
            ArrayList<String> strings = new ArrayList<>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                strings.add(entry.getValue());
            }
            this.compentencies.add(new Compentency(strings.get(0), strings.get(1), strings.get(2)));
        }
    }

    @Override
    public String plural() throws Exception {
        return "topics";
    }
}
