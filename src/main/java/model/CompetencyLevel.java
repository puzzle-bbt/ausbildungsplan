package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class CompetencyLevel {
    private String id;
    private ArrayList<String> instruments;
    private ArrayList<String> goals;
    private int year;
    private YearCalendarWeek yearCalendarWeek;

    public CompetencyLevel(String id, ArrayList<String> instruments, ArrayList<String> goals, int year, YearCalendarWeek yearCalendarWeek) {
        this.id = id;
        this.instruments = instruments;
        this.goals = goals;
        this.year = year;
        this.yearCalendarWeek = yearCalendarWeek;
    }

}
