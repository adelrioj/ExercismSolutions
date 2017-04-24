
class Hamming

  def self.compute(dna1, dna2)
    raise ArgumentError, 'dna strings must have same length' unless dna1.length == dna2.length

    chars_dna1 = dna1.chars
    chars_dna2 = dna2.chars

    chars_dna1.zip(chars_dna2).count { |n1, n2| n1 != n2 }
  end
end