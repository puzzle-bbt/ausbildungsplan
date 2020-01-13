# frozen_string_literal: true

require_relative '../../app/view/renderer'
require_relative '../../app/controller/source_data_reader'
require_relative '../../app/model/semester'
require 'fileutils'

describe Renderer do

  let(:renderer) { Renderer.new(Topic.all, 'spec/') }

  before(:all) do
    FileUtils.mkdir('spec/docs')
  end

  after(:all) do
    FileUtils.rm_rf('spec/docs')
  end

  it 'should render semesters' do
    renderer.render_semesters

    (Semester::SEMESTER_NOS).each { |i| expect(File.exist?("spec/docs/semester#{i}.html")).to be true }

    semester = File.read('spec/docs/semester1.html')
    expect(semester).to include('HTML: Aufbau einer Webseite verstehen: Tags + Attribute.')
  end
end
