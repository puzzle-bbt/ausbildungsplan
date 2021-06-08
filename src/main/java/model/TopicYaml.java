package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class TopicYaml {
    private String id;
    private String title;
    private String description;

    public TopicYaml(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
