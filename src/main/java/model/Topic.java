package model;

import java.util.ArrayList;

public class Topic {
    private String id;
    private String title;
    private String description;
    private ArrayList<Compentency> compentencies;
    private ArrayList<YearCalendarWeek> yearCalendarWeeks;

    public Topic() {
    }

    public Topic(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.compentencies = new ArrayList<>();
        this.yearCalendarWeeks = new ArrayList<>();
    }

    public void addCompetency(Compentency compentency){
        this.compentencies.add(compentency);
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
