# frozen_string_literal: true

require_relative 'semester'
require_relative 'base'
require 'redcarpet'

class CompetencyLevel < Base
  attr_accessor :goals, :instruments, :calendar_week_from,
                :calendar_week_to, :education_year, :id, :level

  def initialize(level)
    @id = level['id']
    @instruments = level['instruments']
    @goals = level['goals']
    @level = level['id'].split('.')[2]
    set_dates
  end

  def set_dates
    topic = CompetencyLevel.data['topics'].find do |yaml_topic|
      next if yaml_topic['year_calendar_weeks'].nil?

      yaml_topic['year_calendar_weeks'].include? @id
    end
    dates = fetch_dates(topic['year_calendar_weeks'][@id])
    @education_year = dates[0]
    @calendar_week_from = dates[1]
    @calendar_week_to = dates[2]
    notify unless valid?
  end

  def valid?
    [calendar_week_to.between?(1, 52),
     calendar_week_from.between?(1, 52),
     education_year.between?(1, 2)].all?
  rescue StandardError
    false
  end

  def notify
    abort "The level with the id #{@id} is invalid"
  end

  def fetch_dates(dates)
    dates.scan(/[0-9]{1,3}/).map(&:to_i)
  end

  def weeks
    if @calendar_week_from < @calendar_week_to
      [*@calendar_week_from..@calendar_week_to]
    else
      [*@calendar_week_from..52, *1..@calendar_week_to]
    end
  end

  def link_text(instrument:)
    Redcarpet::Markdown.new(Redcarpet::Render::HTML.new).render(instrument)
  end

  class << self
    def plural
      'competency_levels'
    end

    def find_by(competency_id: nil, semester: nil)
      if semester.nil?
        find_by_competency(competency_id: competency_id)
      else
        find_by_competency_and_semester(competency_id: competency_id, semester: semester)
      end
    end

    private

    def find_by_competency(competency_id: nil)
      all.select do |level|
        competency_id == level.id[0..2]
      end
    end

    def find_by_competency_and_semester(competency_id: nil, semester: nil)
      all.select do |level|
        competency_id == level.id[0..2] && semester.includes?(level: level)
      end
    end
  end
end
