package model;

import java.util.ArrayList;

public class Compentency {
    private String id;
    private String title;
    private String description;
    private ArrayList<CompentencyLevel> compentencyLevels;

    public Compentency() {
    }

    public Compentency(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.compentencyLevels = new ArrayList<>();
    }

    public void addCompetencyLevel(CompentencyLevel level){
        this.compentencyLevels.add(level);
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
