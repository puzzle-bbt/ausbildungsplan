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
    expect(topics[0]['compentencies'].length).to eq(6)
    expect(topics[1]['compentencies'].length).to eq(3)

    topic = topics[1]
    expect(topic['title']).to eq('UI / Web')

    compentency = topic['compentencies'][0]

    expect(compentency['title']).to eq('User Experience (UX)')
    expect(compentency['levels'].length).to eq(2)
  end
end
