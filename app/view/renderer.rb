# frozen_string_literal: true

require 'haml'
require_relative '../model/semester'

class Renderer

  def initialize(topics, base_path = '')
    @base_path = base_path
    @topics = topics
  end

  def render_semesters
    Semester.all.each do |semester|
      template = File.read('app/view/templates/haml/semester.html.haml')
      engine = Haml::Engine.new(template)
      File.open("#{@base_path}docs/semester#{semester.id}.html", 'w') do |file|
        dates = Time.now.strftime('%d.%m.%Y %H:%M:%S')
        file.write(engine.render(Object.new, topics: @topics, semester: semester, date: dates))
      end
    end
  end
end
