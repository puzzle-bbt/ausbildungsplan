# frozen_string_literal: true

require_relative '../../app/controller/source_data_reader'

describe SourceDataReader do

  let(:reader) { SourceDataReader.new('spec/') }

  it 'should create master file' do
    reader.create_master_yaml

    expect(File.exist?('spec/data/master.yaml')).to be true
    master = File.open('spec/data/master.yaml') { |file| YAML.safe_load(file) }

    config = master['conf']

    expect(config[0]['semester'].length).to eq(2)

    topics = master['topics']
    expect(topics.length).to eq(2)
    expect(topics[0]['competencies'].length).to eq(6)
    expect(topics[1]['competencies'].length).to eq(3)

    topic = topics[1]
    expect(topic['title']).to eq('UI / Web')

    competency = topic['competencies'][0]

    expect(competency['title']).to eq('User Experience (UX)')
    expect(competency['levels'].length).to eq(2)
  end

  it 'should create topics' do
    topics = reader.fetch_topics
    expect(topics.length).to eq(2)

    topic = topics[0]
    expect(topic.title).to eq('Applikationsentwicklung')
    expect(topic.competencies.length).to eq(6)

    competency = topic.competencies[0]
    expect(competency.title).to eq('Single-Page-Applikation')
    expect(competency.competency_levels.length).to eq(1)

    level = competency.competency_levels[0]
    expect(level.goals[0]).to eq('Funktionsweise einer Single-Page-Webanwendung verstehen')
    expect(level.calendar_week_from).to eq(31)
    expect(level.calendar_week_to).to eq(5)
    expect(level.education_year).to eq(2)
    expect(level.valid?).to be true
  end

  it 'should read the config' do
    config = reader.fetch_config
    expect(config.length).to eq(1)

    semester = config[0]['semester'][0]

    expect(semester['start_at_week_nr']).to eq(33)
    expect(semester['finish_at_week_nr']).to eq(4)
  end
end
