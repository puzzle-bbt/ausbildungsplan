# frozen_string_literal: true

require_relative '../../app/model/competency_level'
require 'pry'

describe CompetencyLevel do

  let(:semesters) do
    reader = SourceDataReader.new('spec/')
    reader.fetch_config[0]['semester']
  end

  it 'should return semester' do
    dates = {121=>"3 35-3"}
    level = CompetencyLevel.new({"goals"=>["Funktionsweise einer Single-Page-Webanwendung verstehen"], "instruments"=>["Hilfsmittel sind noch zu definieren."], "id"=>121}, dates)
    semester= level.semester(semesters)
    expect(semester).to eq(5)

    level.calendar_week_from = 6
    level.calendar_week_to = 7
    semester= level.semester(semesters)
    expect(semester).to eq(6)

    level.education_year = 1
    level.calendar_week_from = 33
    level.calendar_week_to = 4
    semester= level.semester(semesters)
    expect(semester).to eq(1)
  end

  it 'should validate level' do
    dates = {121=>"3 35-3"}
    level = CompetencyLevel.new({"goals"=>["Funktionsweise einer Single-Page-Webanwendung verstehen"], "instruments"=>["Hilfsmittel sind noch zu definieren."], "id"=>121}, dates)
    expect(level).to be_valid

    begin
    dates = {122=>"3 350-3"}
    level = CompetencyLevel.new({"goals"=>["Funktionsweise einer Single-Page-Webanwendung verstehen"], "instruments"=>["Hilfsmittel sind noch zu definieren."], "id"=>122}, dates)
    expect(level.valid?).to be false
    rescue Exception => e
    end

    begin
    dates = {123=>""}
    level = CompetencyLevel.new({"goals"=>["Funktionsweise einer Single-Page-Webanwendung verstehen"], "instruments"=>["Hilfsmittel sind noch zu definieren."], "id"=>123}, dates)
    expect(level.valid?).to be false
    rescue Exception => e
    end

  end
end
