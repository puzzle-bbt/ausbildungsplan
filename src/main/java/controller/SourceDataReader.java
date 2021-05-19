package controller;

public class SourceDataReader{
        public void initialize() {

        }

        public void createMasterYaml() {

        }

        private void readTopics(){

        }

        private void readCompetencies(){

        }

        private void readCompetencyLevels(){

        }

        private void readConfig(){

        }

        private void extractId(){

        }
}

//  attr_writer :base_path
//
//        ID_REGEX=/[0-9]{1,3}$/.freeze
//



//                def initialize(base_path='')
//        @base_path =base_path
//                end
//
//        def create_master_yaml
//        comment='# This is an automaticly generated file. Don\'t edit this file manually'
//                master={'topics'=>topics,'competencies'=>competencies, \
//                'competency_levels'=>competency_levels,'conf'=>config}
//                File.open("#{@base_path}data/master.yaml",'w')do|file|
//        file.puts comment
//        file.write(master.to_yaml)
//        end
//        end
//
//        private
//
//        def topics
//        Dir.glob("#{@base_path}data/topics/**/topic.yaml").map do|topic_path|
//        yaml=File.open(topic_path){|file|YAML.safe_load(file)}
//        yaml.merge!('id'=>extract_id(topic_path))
//        end
//        end
//
//        def competencies
//        path="#{@base_path}data/topics/**/competencies/**/competency.yaml"
//        Dir.glob(path).map do|competency_path|
//        competency=File.open(competency_path){|file|YAML.safe_load(file)}
//        competency.merge('id'=>extract_id(competency_path))
//        end
//        end
//
//        def competency_levels
//        path="#{@base_path}data/topics/**/competencies/**/levels/*"
//        Dir.glob(path).map do|level_path|
//        level=File.open(level_path){|file|YAML.safe_load(file)}
//        level.merge('id'=>extract_id(level_path))
//        end
//        end
//
//        def config
//        Dir.glob("#{@base_path}data/conf/*").map do|conf_path|
//        File.open(conf_path){|file|YAML.safe_load(file)}
//        end
//        end
//
//        def extract_id(object_path)
//        object_path.scan(/[0-9]{1,3}/).join('.')
//        end
//        end
