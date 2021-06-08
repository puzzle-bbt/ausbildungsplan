package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class Semester{
    private ArrayList<YearCalendarWeek> year_calendar_weeks;

    public Semester(ArrayList<YearCalendarWeek> year_calendar_weeks) {
        this.year_calendar_weeks = year_calendar_weeks;
    }
}
