package model;

import java.util.ArrayList;

public class CompentencyLevelYaml {
    private String id;
    private String competency_id;
    private ArrayList<String> instruments;
    private ArrayList<String> goals;

    public CompentencyLevelYaml() {
    }

    public CompentencyLevelYaml(String id, String competency_id, ArrayList<String> instruments, ArrayList<String> goals) {
        this.id = id;
        this.competency_id = competency_id;
        this.instruments = instruments;
        this.goals = goals;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompetency_id() {
        return competency_id;
    }

    public void setCompetency_id(String competency_id) {
        this.competency_id = competency_id;
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
}
