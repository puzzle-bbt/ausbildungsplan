# frozen_string_literal: true

require_relative 'source_data_reader'

class Builder
  @reader = SourceDataReader.new('')
  @reader.create_master_yaml
end
