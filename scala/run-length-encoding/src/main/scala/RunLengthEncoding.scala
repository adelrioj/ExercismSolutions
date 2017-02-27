object RunLengthEncoding {

    def encode(str: String): String = {
        def encodeList(strList: List[Char]): List[(Int, Char)] = strList match {
            case Nil => Nil
            case y :: ys => encodeList(ys) match {
                case (c, `y`) :: rest => (c + 1, y) :: rest
                case             rest => (    1, y) :: rest
            }
        }

        encodeList(str.toList) map {
            case (1, char) => s"$char"
            case (int, char) => s"$int$char"
        } mkString
    }

    def decode(str: String): String = {
        val pattern =  """(\d*)([a-zA-Z\s])""".r

        def checkLenght(l: String) = l match {
            case "" => 1
            case s => s.toInt
        }

        (for (pattern(l, c) <- pattern findAllIn str)
            yield c * checkLenght(l)) mkString
    }
}
