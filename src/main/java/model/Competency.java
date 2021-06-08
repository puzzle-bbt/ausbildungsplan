package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class Competency {
    private String id;
    private String title;
    private String description;
    private ArrayList<CompetencyLevel> competencyLevels;

    public Competency(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.competencyLevels = new ArrayList<>();
    }

    public void addCompetencyLevel(CompetencyLevel level) {
        this.competencyLevels.add(level);
    }

}
