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

    public Plan(ArrayList<Topic> topics) {
        this.topics = topics;
    }
}
