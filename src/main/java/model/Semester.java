package model;

public class Semester{
    private int id;
    private YearCalendarWeek[] yearCalendarWeeks;


    public Semester(int id, YearCalendarWeek[] yearCalendarWeek) {
        this.id = id;
        this.yearCalendarWeeks = yearCalendarWeek;
    }
}
