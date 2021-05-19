package controller;

public class Builder{

    private SourceDataReader reader  = new SourceDataReader();

    public void initialize () {
        reader.createMasterYaml();

    }
}


//  def initialize
//          reader.create_master_yaml
//        topics=Topic.all
//        renderer=Renderer.new(topics)
//        renderer.render_semesters
//        renderer.render_overview
//        renderer.render_index
//        end
//
//private
//
//  def reader
//@reader ||=SourceDataReader.new
//        end
//        end
