# frozen_string_literal: true

class Base


  def plural
    raise 'implement in subclass'
  end

  class << self
    attr_accessor :base_path

    def all
      objects = data[plural].map do |object|
        new(object)
      end
      objects.sort_by { |object| object.id }
    end

    def find(id: nil)
      new(data[plural].find { |object| object['id'] == id })
    end

    def data
      @data ||= File.open("#{base_path}data/master.yaml") { |file| YAML.safe_load(file) }
    end
  end
end
