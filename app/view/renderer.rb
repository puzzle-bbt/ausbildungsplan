# frozen_string_literal: true

require 'haml'
require_relative '../model/semester'

class Renderer

  YEARS = [1, 2, 3, 4].freeze
  TEMPLATE_OVERVIEW = 'app/view/templates/haml/overview.html.haml'
  TEMPLATE_SEMESTER = 'app/view/templates/haml/semester.html.haml'
  TEMPLATE_NAVIGATION = 'app/view/templates/haml/navigation.html.haml'
  TEMPLATE_INDEX = 'app/view/templates/haml/index.html.haml'

  def initialize(topics, base_path = '')
    @base_path = base_path
    @topics = topics
  end

  def render_semesters
    engine = Haml::Engine.new(File.read(TEMPLATE_SEMESTER))
    Semester.all.each do |semester|
      File.open("#{@base_path}docs/semester#{semester.id}.html", 'w') do |file|
        dates = Time.now.strftime('%d.%m.%Y %H:%M:%S')
        data = { topics: @topics, semester: semester, date: dates, navigation: navigation }
        file.write(engine.render(Object.new, data))
      end
    end
  end

  def render_overview
    engine = Haml::Engine.new(File.read(TEMPLATE_OVERVIEW))
    YEARS.each do |year|
      File.open("#{@base_path}docs/overview#{year}.html", 'w') do |file|
        data = { topics: @topics, months: months, weeks: weeks, year: year, navigation: navigation }
        file.write(engine.render(Object.new, data))
      end
    end
  end

  def render_index
    engine = Haml::Engine.new(File.read(TEMPLATE_INDEX))
    File.open("#{@base_path}docs/index.html", 'w') do |file|
      file.write(engine.render(Object.new, navigation: navigation))
    end
  end

  private

  def navigation
    @navigation ||= Haml::Engine.new(File.read(TEMPLATE_NAVIGATION)).render
  end

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
