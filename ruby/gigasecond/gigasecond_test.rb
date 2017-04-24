require 'minitest/autorun'
require_relative 'gigasecond'

# Test data version: 9049dc7

class GigasecondTest < Minitest::Test
  def test_2011_04_25
    result = Gigasecond.from(Time.utc(2011, 4, 25, 0, 0, 0))
    assert_equal Time.utc(2043, 1, 1, 1, 46, 40), result
  end

  def test_1977_06_13
    result = Gigasecond.from(Time.utc(1977, 6, 13, 0, 0, 0))
    assert_equal Time.utc(2009, 2, 19, 1, 46, 40), result
  end

  def test_1959_07_19
    result = Gigasecond.from(Time.utc(1959, 7, 19, 0, 0, 0))
    assert_equal Time.utc(1991, 3, 27, 1, 46, 40), result
  end

  def test_full_time_specified
    result = Gigasecond.from(Time.utc(2015, 1, 24, 22, 0, 0))
    assert_equal Time.utc(2046, 10, 2, 23, 46, 40), result
  end

  def test_full_time_with_day_roll_over
    result = Gigasecond.from(Time.utc(2015, 1, 24, 23, 59, 59))
    assert_equal Time.utc(2046, 10, 3, 1, 46, 39), result
  end
end
