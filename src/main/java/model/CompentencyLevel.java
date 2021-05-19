package model;

public class CompentencyLevel extends Base{
    private int id;
    private String[] instruments;
    private String[] goals;
    private int level;

    public CompentencyLevel(int id, String[] instruments, String[] goals, int level) {
        this.id = id;
        this.instruments = instruments;
        this.goals = goals;
        this.level = level;
    }

    @Override
    public String plural() throws Exception {
        return "competency_levels";
    }
}
