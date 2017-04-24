
class Gigasecond

  ONE_GIGASECOND = 1_000_000_000

  def self.from(birth_date)
    birth_date + ONE_GIGASECOND
  end
end