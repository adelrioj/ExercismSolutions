case class Anagram(anagram: String) {

    def matches(possibleAnagrams: Seq[String]): Seq[String] = {

        val lcAnagram = anagram toLowerCase

        def isAnagram(candidate: String): Boolean = {
            val lcCandidate = candidate toLowerCase

            lcCandidate != lcAnagram &&
              lcCandidate.sorted == lcAnagram.sorted
        }

        possibleAnagrams filter isAnagram
    }

}
