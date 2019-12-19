# frozen_string_literal: true

require 'safe_yaml'

class SourceDataReader

  attr_writer :base_path

  ID_REGEX = /[0-9]{1,3}$/.freeze

  def initialize(base_path)
    @base_path = base_path
  end

  def create_master_yaml
    comment = '# This is an automaticly generated file. Don\'t edit this file manually'
    master = { 'topics' => topics, 'conf' => config }
    File.open(@base_path + 'data/master.yaml', 'w') do |file|
      file.puts comment
      file.write(master.to_yaml)
    end
  end

  private

  def topics
    Dir.glob(@base_path + 'data/topics/*').map do |topic_path|
      File.open(topic_path + '/topic.yaml') do |file|
        id = topic_path[ID_REGEX]
        yaml = YAML.safe_load(file).merge('compentencies' => compentencies(id))
        yaml.merge!('id' => extract_id(topic_path))
      end
    end
  end

  def compentencies(topic_id)
    path = @base_path + 'data/topics/' + topic_id + '/compentencies'
    return unless Dir.exist?(path)

    Dir.glob(path + '/*').map do |competency_path|
      yaml = File.open(competency_path + '/compentency.yaml') { |file| YAML.safe_load(file) }
      yaml.merge!('id' => extract_id(competency_path))
      yaml.merge!('levels' => competency_levels(competency_path[ID_REGEX], topic_id))
    end
  end

  def competency_levels(competency_id, topic_id)
    path = @base_path + 'data/topics/' + topic_id + '/compentencies/' + competency_id + '/levels'
    return unless Dir.exist?(path)

    Dir.glob(path + '/*').map do |level_path|
      level = File.open(level_path) { |file| YAML.safe_load(file) }
      level.merge('id' => extract_id(level_path))
    end
  end

  def config
    Dir.glob(@base_path + 'data/conf/*').map do |conf_path|
      File.open(conf_path) { |file| YAML.safe_load(file) }
    end
  end

  def extract_id(object_path)
    object_path.scan(/[0-9]{1,3}/).join.to_i
  end
end
