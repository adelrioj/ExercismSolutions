
object s_+: {
    def unapply(s: String): Option[(Char, String)] = s.headOption map { (_, s.tail) }
}

object Hamming {

    def compute(dna1: String, dna2: String):Option[Int] = {

        def checkValue[A](c1:A, c2:A) = if (c1 == c2) 0 else 1

        def notConsistent(xs: String, ys: String) = {
            (xs.isEmpty && ys.nonEmpty) || (xs.nonEmpty && ys.isEmpty)
        }

        def computeInRecLoop(xs: String, ys: String, acc: Int): Option[Int] =
            (xs, ys) match {
                case (`xs`, `ys`) if notConsistent(xs, ys) => None
                case ("", "") => Some(acc)
                case (x s_+: xTail, y s_+: yTail) => computeInRecLoop(xTail, yTail, acc + checkValue(x, y))
            }

        computeInRecLoop(dna1, dna2, 0)
    }

}
