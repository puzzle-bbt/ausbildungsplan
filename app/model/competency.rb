# frozen_string_literal: true

class Competency
  attr_accessor :competency_levels, :title, :description

  def initialize(competency_levels, competency)
    @competency_levels = competency_levels
    @title = competency['title']
    @description = competency['description']
  end

end
