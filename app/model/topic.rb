# frozen_string_literal: true

require_relative 'base'
require_relative 'competency'

class Topic < Base
  attr_accessor :title, :description, :id, :year_calendar_weeks

  def initialize(topic)
    @id = topic['id']
    @title = topic['title']
    @description = topic['description']
    @year_calendar_weeks = topic['year_calendar_weeks']
  end

  def competencies
    @competencies ||= Competency.find_by(topic_id: @id)
  end

  class << self
    def plural
      'topics'
    end
  end

  def semester_topic(semester, config_semesters)
    return unless @competencies.any?

    competencies = @competencies.map do |competency|
      competency.semester_competency(semester, config_semesters)
    end
    Topic.new(competencies, 'title' => @title, 'description' => @description)
  end
end
