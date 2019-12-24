# frozen_string_literal: true

class Topic
  attr_accessor :title, :description, :competencies

  def initialize(competencies, topic)
    @title = topic['title']
    @description = topic['description']
    @competencies = competencies
  end
end
