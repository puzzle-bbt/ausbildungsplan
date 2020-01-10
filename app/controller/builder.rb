# frozen_string_literal: true

require_relative 'source_data_reader'
require_relative '../model/competency_level'
require_relative '../view/renderer'

class Builder

  def initialize
    reader.create_master_yaml
    topics = Topic.all
    renderer = Renderer.new(topics)
    renderer.render_semesters
  end

  private

  def reader
    @reader ||= SourceDataReader.new
  end
end
