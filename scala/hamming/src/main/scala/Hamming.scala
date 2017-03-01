import scala.annotation.tailrec

object Hamming {

    def compute(dna1: String, dna2: String):Option[Int] = {

        def distance[A](c1:A, c2:A) = if (c1 == c2) 0 else 1

        @tailrec
        def computeInRecLoop(xs: Seq[Char], ys: Seq[Char], acc: Int): Option[Int] =
            (xs, ys) match {
                case (Nil, Nil) => Some(acc)
                case (x+:xTail, y+:yTail) => computeInRecLoop(xTail, yTail, acc + distance(x, y))
                case _ => None
            }

        computeInRecLoop(dna1, dna2, 0)
    }

}