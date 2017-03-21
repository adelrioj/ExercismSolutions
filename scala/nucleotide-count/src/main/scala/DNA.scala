
class DNA(dna: String) {

  val nucleotides: Set[Char] = Set('A', 'T', 'C', 'G')
  val emptyNucleotideCount: Either[String, Map[Char, Int]] = Right(nucleotides map(_ -> 0) toMap)

  def count(c: Char): Either[String, Int] = {
    for{
      checkedNucleotide <- checkNucleotide(c).right
      nucleotideCount <- nucleotideCounts.right
    } yield nucleotideCount(checkedNucleotide)
  }

  def nucleotideCounts: Either[String, Map[Char, Int]] = {

    dna.foldLeft(emptyNucleotideCount){
      (nucleotideCounts, char) => for {
        nucleotide <- checkNucleotide(char).right
        counts <- nucleotideCounts.right
      } yield counts + (nucleotide -> (counts.getOrElse(nucleotide, 0) + 1))
    }
  }

  private def checkNucleotide(nucleotide: Char): Either[String, Char] ={
    if (nucleotides contains nucleotide) Right(nucleotide)
    else Left(s"""invalid nucleotide '$nucleotide'""")
  }

}
