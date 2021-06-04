package model;

public class TopicYaml {
    private String id;
    private String title;
    private String description;

    public TopicYaml() {
    }

    public TopicYaml(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
