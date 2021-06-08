package model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
@Getter
@Setter
public class CompetencyYaml {
    private String id;
    private String topic_id;
    private String title;
    private String description;

    public CompetencyYaml(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.parseAndSetTopicId();
    }

    public void parseAndSetTopicId() {
        String regex = "(\\d+)\\.\\d+";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(this.id);

        if (matcher.find()) {
            this.topic_id = matcher.group(1);
        }
    }
}
