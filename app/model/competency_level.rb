# frozen_string_literal: true

class CompetencyLevel
  attr_accessor :goals, :instruments, :calendar_week_from,
                :calendar_week_to, :education_year, :id

  def initialize(level, dates)
    @id = level['id']
    d = dates[@id].scan(/[0-9]{1,3}/)
    @education_year = d[0].to_i
    @calendar_week_from = d[1].to_i
    @calendar_week_to = d[2].to_i
    @instruments = level['instruments']
    @goals = level['goals']
    notify unless valid?
  end

  def valid?
    [@calendar_week_to.between?(1, 52),
     @calendar_week_from.between?(1, 52),
     @education_year.between?(1, 4)].all?
  end

  def notify
    abort "The level with the id #{@id} is invalid"
  end

  def semester(semesters)
    if first_semester?(semesters)
      education_year * 2 - 1
    elsif second_semester?(semesters)
      education_year * 2
    end
  end

  private

  def first_semester?(semesters)
    calendar_week_from.between?(semesters[0]['start_at_week_nr'], 52) ||
        calendar_week_from.between?(semesters[0]['finish_at_week_nr'], 1)
  end

  def second_semester?(semesters)
    calendar_week_from.between?(semesters[1]['start_at_week_nr'], semesters[1]['finish_at_week_nr'])
  end
end
