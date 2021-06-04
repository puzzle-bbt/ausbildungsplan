package model;

public class YearCalendarWeek {
    private int id;
    private String level;
    private int apprenticeshipYear;
    private int startWeek;
    private int endWeek;

    public YearCalendarWeek(int id, int startWeek, int endWeek) {
        this.id = id;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
    }
}
