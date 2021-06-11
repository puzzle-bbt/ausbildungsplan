package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class WeeksTopicYaml {
    private ArrayList<LevelYearCalendarWeek> level_year_calendar_weeks;
}
