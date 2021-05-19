package model;

public class Topic extends Base {
    private int id;
    private String title;
    private String description;
    private YearCalendarWeek[] yearCalendarWeeks;

    public Topic(int id, String title, String description, YearCalendarWeek[] yearCalendarWeeks) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.yearCalendarWeeks = yearCalendarWeeks;
    }

    @Override
    public String plural() throws Exception {
        return "topics";
    }
}
