object Hamming {

    def compute(dna1: String, dna2: String):Option[Int] = {
        if (dna1.length != dna2.length)
            None
        else
            Some(
                dna1 zip dna2 count {
                    case (a, b) => a != b
                }
            )
    }

}
