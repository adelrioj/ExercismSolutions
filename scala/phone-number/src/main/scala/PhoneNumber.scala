class PhoneNumber(s: String) {

    val number: Option[String] = (s.filter(_.isDigit) match {
        case x if x.length == 10 => Some(x)
        case x +: xs if x == '1' && xs.length == 10 => Some(xs)
        case _ => None
    }).map(_.mkString)


    val areaCode: Option[String] = {
        def calcAreaCode(phone: Seq[Char]): Seq[Char] = phone.take(3)
        number.map(calcAreaCode(_).mkString)
    }

    val prettyPrint: Option[String] = number.map{ x =>
        val area = areaCode.get
        val prefix = x slice (3, 6)
        val suffix = x drop 6

        s"""($area) $prefix-$suffix"""
    }
}
