package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class CompetencyLevel {
    private String id;
    private ArrayList<String> instruments;
    private ArrayList<String> goals;

    public CompetencyLevel(String id, ArrayList<String> instruments, ArrayList<String> goals) {
        this.id = id;
        this.instruments = instruments;
        this.goals = goals;
    }

}
