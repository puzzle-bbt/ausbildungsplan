package model;

public class Compentency extends Base{
    private int id;
    private String title;
    private String description;

    public Compentency(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }


    @Override
    public String plural() {
        return "competencies";
    }



}

//class Competency < Base
//  attr_accessor :title, :description, :id, :filtered_levels
//
//        def initialize(competency)
//@id = competency['id']
//@title = competency['title']
//@description = competency['description']
//        end
//
//        def competency_levels
//@competency_levels ||= CompetencyLevel.find_by(competency_id: @id)
//        end
//
//        def competency_levels_by_semester(semester)
//        CompetencyLevel.find_by(competency_id: @id, semester: semester)
//        end
//
//class << self
//        def plural
//        'competencies'
//        end
//
//        def find_by(topic_id:)
//        all.select do |competency|
//        topic_id == competency.id[0]
//        end
//        end
//        end
//        end
