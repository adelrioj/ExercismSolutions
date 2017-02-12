object SumOfMultiples {
    def sumOfMultiples(factors: Set[Int], limit: Int): Int = {
        (for {
            i <- 1 until limit
            factor <- factors
            if i % factor == 0
        } yield i).distinct.sum
    }
}

