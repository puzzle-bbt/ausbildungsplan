package model;

public class CompentencyYaml {
    private String id;
    private String topic_id;
    private String title;
    private String description;

    public CompentencyYaml() {
    }

    public CompentencyYaml(String id, String topic_id, String title, String description) {
        this.id = id;
        this.topic_id = topic_id;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
