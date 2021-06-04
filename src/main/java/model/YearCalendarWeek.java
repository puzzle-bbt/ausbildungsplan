package model;

public class YearCalendarWeek {
    private int start_at_week_nr;
    private int finish_at_week_nr;


    public YearCalendarWeek() {
    }

    public YearCalendarWeek(int start_at_week_nr, int finish_at_week_nr) {
        this.start_at_week_nr = start_at_week_nr;
        this.finish_at_week_nr = finish_at_week_nr;
    }

    public int getStart_at_week_nr() {
        return start_at_week_nr;
    }

    public void setStart_at_week_nr(int start_at_week_nr) {
        this.start_at_week_nr = start_at_week_nr;
    }

    public int getFinish_at_week_nr() {
        return finish_at_week_nr;
    }

    public void setFinish_at_week_nr(int finish_at_week_nr) {
        this.finish_at_week_nr = finish_at_week_nr;
    }
}
