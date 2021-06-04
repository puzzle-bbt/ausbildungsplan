package model;

import java.util.ArrayList;

public class Plan {
    ArrayList<Topic> topics;

    public Plan() {
    }

    public Plan(ArrayList<Topic> topics) {
        this.topics = topics;
    }

    public ArrayList<Topic> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<Topic> topics) {
        this.topics = topics;
    }
}
