# frozen_string_literal: true

require_relative 'source_data_reader'
require_relative '../model/competency_level'

class Builder

  def initialize
    reader.create_master_yaml
    reader.fetch_topics
    reader.fetch_config
  end

  private

  def reader
    @reader ||= SourceDataReader.new
  end
end
