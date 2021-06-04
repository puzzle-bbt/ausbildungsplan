package model;

import java.util.ArrayList;

public class Semester{
    private ArrayList<YearCalendarWeek> year_calendar_weeks;

    public Semester() {
    }

    public Semester(ArrayList<YearCalendarWeek> year_calendar_weeks) {
        this.year_calendar_weeks = year_calendar_weeks;
    }

    public ArrayList<YearCalendarWeek> getYear_calendar_weeks() {
        return year_calendar_weeks;
    }

    public void setYear_calendar_weeks(ArrayList<YearCalendarWeek> year_calendar_weeks) {
        this.year_calendar_weeks = year_calendar_weeks;
    }
}
