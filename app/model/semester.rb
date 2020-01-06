# frozen_string_literal: true

require_relative 'base'

class Semester < Base

  attr_accessor :start_week, :finish_week, :id

  YEAR_START = 1
  YEAR_END = 52
  SEMESTER_NOS = [1, 2, 3, 4, 5, 6, 7, 8].freeze

  def initialize(id, config_semester)
    @id = id
    @start_week = config_semester['start_at_week_nr']
    @finish_week = config_semester['finish_at_week_nr']
  end

  def includes?(level:)
    if first?(level.calendar_week_from)
      semester = level.education_year * 2 - 1
    elsif second?(level.calendar_week_from)
      semester = level.education_year * 2
    end
    semester == @id
  end

  def first?(level_start_week)
    level_start_week.between?(@start_week, YEAR_END) ||
        level_start_week.between?(YEAR_START, @finish_week)
  end

  def second?(level_start_week)
    level_start_week.between?(@start_week, @finish_week)
  end

  class << self
    def all
      config_semesters = Semester.data['conf'][0]['semester']
      SEMESTER_NOS.map do |semester_no|
        s = semester_no.odd? ? 0 : 1
        new(semester_no, config_semesters[s])
      end
    end
  end
end
