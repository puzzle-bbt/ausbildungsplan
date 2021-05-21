package controller;

import model.Plan;

public class Builder{


    public static void main(String[] args){
        SourceDataReader reader  = new SourceDataReader();
        reader.createMasterYaml();
        Plan plan = new Plan();
        plan.getTopics();
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
