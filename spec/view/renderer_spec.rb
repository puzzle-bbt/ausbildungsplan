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
    expect(semester).to include('Semester')
    expect(semester).to include('Jahre')
  end

  it 'should render the overview' do
    renderer.render_overview

    (Renderer::YEARS).each { |i| expect(File.exist?("spec/docs/overview#{i}.html")).to be true }

    overview = File.read('spec/docs/overview1.html')

    expect(overview).to include('UI / Web')
    expect(overview).to include('Applikationsentwicklung')
    expect(overview).to include('Responsive Webseite verstehen und umsetzen können.')
    expect(overview).to include('Semester')
    expect(overview).to include('Jahre')
  end

  it 'should render index' do
    renderer.render_index

    expect(File.exist?('spec/docs/index.html')).to be true

    index = File.read('spec/docs/index.html')

    expect(index).to include('Applikationsentwickler EFZ - Web Engineering')
    expect(index).to include('Semester')
    expect(index).to include('Jahre')
  end


end
