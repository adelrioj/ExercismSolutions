
module BookKeeping
  VERSION = 4
end

class Complement

  TRANSCRIPTION_MAP = {
    G: 'C',
    C: 'G',
    T: 'A',
    A: 'U'
  }.freeze

  def self.of_dna(dna)
    dna.each_char.map do |c|
      TRANSCRIPTION_MAP.fetch(c.to_sym) { return '' }
    end.join
  end
q
end