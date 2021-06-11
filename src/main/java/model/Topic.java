package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class Topic {
    private String id;
    private String title;
    private String description;
    private ArrayList<Competency> compentencies;

    public Topic(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.compentencies = new ArrayList<>();
    }

    public void addCompetency(Competency competency) {
        this.compentencies.add(competency);
    }

}
