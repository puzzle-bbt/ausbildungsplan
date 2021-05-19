package view;

import model.Topic;

public class Renderer {

    public static final int[] YEARS = {1, 2, 3, 4};
    public static final String TEMPLATE_OVERVIEW = "app/view/templates/haml/overview.html.haml";
    public static final String TEMPLATE_SEMESTER = "app/view/templates/haml/semester.html.haml";
    public static final String TEMPLATE_NAVIGATION = "app/view/templates/haml/navigation.html.haml";
    public static final String TEMPLATE_INDEX = "app/view/templates/haml/index.html.haml";


    private Topic[] topics;
    private String basePath = "";


    public Renderer(Topic[] topics) {
        this.topics = topics;
    }
}
