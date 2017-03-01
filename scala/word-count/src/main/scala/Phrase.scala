
class Phrase(s: String) {

  def wordCount: Map[String, Int] = {

    val pattern = "\\W+('\\W+)?".r

    def checkForWord(map: Map[String, Int], word: String) = {
      val lcWord = word.toLowerCase
      map + (lcWord -> (map.getOrElse(lcWord, 0) + 1))
    }

    pattern.findAllMatchIn(s).foldLeft(Map.empty[String, Int])(checkForWord)
  }
}
