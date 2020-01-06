# frozen_string_literal: true

require 'haml'
require_relative '../model/semester'

class Renderer

  YEARS = [1, 2, 3, 4].freeze
  TEMPLATE_OVERVIEW = 'app/view/templates/haml/overview.html.haml'
  TEMPLATE_SEMESTER = 'app/view/templates/haml/semester.html.haml'

  def initialize(topics, base_path = '')
    @base_path = base_path
    @topics = topics
  end

  def render_semesters
    engine = Haml::Engine.new(File.read(TEMPLATE_SEMESTER))
    Semester.all.each do |semester|
      File.open("#{@base_path}docs/semester#{semester.id}.html", 'w') do |file|
        dates = Time.now.strftime('%d.%m.%Y %H:%M:%S')
        file.write(engine.render(Object.new, topics: @topics, semester: semester, date: dates))
      end
    end
  end

  def render_overview
    engine = Haml::Engine.new(File.read(TEMPLATE_OVERVIEW))
    YEARS.each do |year|
      File.open("#{@base_path}docs/overview#{year}.html", 'w') do |file|
        html = engine.render(Object.new, topics: @topics, months: months, weeks: weeks, year: year)
        file.write(html)
      end
    end
  end

  private

  def months
    [*8..12, *1..7].map do |month|
      Date.new(2019, month, -1)
    end
  end

  def weeks
    s1 = Semester.find(id: 1)
    s2 = Semester.find(id: 2)
    [*s1.start_week..Semester::YEAR_END, *Semester::YEAR_START..s2.finish_week]
  end
end
