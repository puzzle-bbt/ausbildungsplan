# frozen_string_literal: true

require_relative '../../app/model/topic'

describe Topic do

  before do
    Topic.base_path = 'spec/'
  end

  it 'should return all Topics' do
    topics = Topic.all

    expect(topics.length).to eq(2)
    expect(topics[0].title).to eq('UI / Web')
  end

  it 'should return Topic by id 1' do
      topic = Topic.find(id: '1')

      expect(topic.title).to eq('UI / Web')
  end
end
