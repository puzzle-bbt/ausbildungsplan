# frozen_string_literal: true

require_relative '../../app/model/competency'

describe Competency do

  before do
    Topic.base_path = 'spec/'
  end

  it 'should return all Compentencies' do
    compentencies = Competency.all

    expect(compentencies.length).to eq(9)
    expect(compentencies[1].title).to eq('JavaScript in Webseiten')
  end

  it 'should reaturn Competency by id 1' do
      competency = Competency.find(id: '1.1')

      expect(competency.title).to eq('Statische Webseite')
  end

  it 'should return Compentencies by Topic' do
      compentencies = Competency.find_by(topic_id: '1')

      expect(compentencies.length).to eq(3)
      expect(compentencies[0].title).to eq('Statische Webseite')
  end
end
