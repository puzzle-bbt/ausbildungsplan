package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class Plan {
    ArrayList<Topic> topics;
    Semester semester;

    public Plan(ArrayList<Topic> topics, Semester semester) {
        this.topics = topics;
        this.semester = semester;
    }
}
