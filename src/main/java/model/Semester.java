package model;

public class Semester extends Base{
    private int id;
    private YearCalendarWeek[] yearCalendarWeeks;


    public Semester(int id, YearCalendarWeek[] yearCalendarWeek) {
        this.id = id;
        this.yearCalendarWeeks = yearCalendarWeek;
    }
}
