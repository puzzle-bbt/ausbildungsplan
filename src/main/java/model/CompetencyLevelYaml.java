package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
@Getter
@Setter
public class CompetencyLevelYaml {
    private String id;
    private String competency_id;
    private ArrayList<String> instruments;
    private ArrayList<String> goals;

    public CompetencyLevelYaml(String id, ArrayList<String> instruments, ArrayList<String> goals) {
        this.id = id;
        this.instruments = instruments;
        this.goals = goals;
        this.parseAndSetCompetencyId();
    }

    public void parseAndSetCompetencyId() {
        String regex = "(\\d+\\.\\d+)\\.\\d+";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(this.id);

        if (matcher.find()) {
            this.competency_id = matcher.group(1);
        }

        /*
        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));

            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
         */
    }
}
