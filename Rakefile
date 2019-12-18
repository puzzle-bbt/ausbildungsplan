# frozen_string_literal: true

require 'rake'
require 'rspec/core/rake_task'

task default: [:build]

RSpec::Core::RakeTask.new(:spec)

task :build do
  ruby 'app/controller/builder.rb'
end
