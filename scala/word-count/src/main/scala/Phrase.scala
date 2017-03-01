
class Phrase(s: String) {

  def wordCount: Map[String, Int] = {

    val pattern = """[^\w']+"""

    def checkForWord(map: Map[String, Int], word: String) = {
      val lcWord = word.toLowerCase
      map + (lcWord -> (map.getOrElse(lcWord, 0) + 1))
    }

    s.split(pattern).foldLeft(Map.empty[String, Int])(checkForWord)

  }
}
