package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LevelYearCalendarWeek {
    private String id;
    private Integer year;
    private YearCalendarWeek year_calendar_week;

    public LevelYearCalendarWeek(String id, Integer year, YearCalendarWeek year_calendar_week) {
        this.id = id;
        this.year = year;
        this.year_calendar_week = year_calendar_week;
    }
}
