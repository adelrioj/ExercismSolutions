class Bob {
    def hey(speech: String) ={

        def allLetterAreUppercase(s: String) = (s.count(_.isUpper) > 0) && (s.count(_.isLower) == 0)

        speech match {
            case s if s.trim.isEmpty => "Fine. Be that way!"
            case s if allLetterAreUppercase(s) => "Whoa, chill out!"
            case s if s.endsWith("?") => "Sure."
            case _ => "Whatever."
        }
    }

}
