object Pangrams {

    def isPangram(s: String): Boolean = {
        val lcString = s.toLowerCase
        'a' to 'z' dropWhile (lcString contains _) isEmpty
    }
}
