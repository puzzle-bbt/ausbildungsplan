# frozen_string_literal: true

require 'rake'
require 'rspec/core/rake_task'
require_relative 'app/controller/builder'

task default: [:build]

RSpec::Core::RakeTask.new(:spec)

task :build do
  Builder.new
end
