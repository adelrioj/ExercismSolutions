class PhoneNumber(s: String) {

    val number: Option[String] = s.filter(_.isDigit) match {
        case x if x.length == 10 => Some(x)
        case x if x.startsWith("1") && x.length == 11 => Some(x.tail)
        case _ => None
    }


    val areaCode: Option[String] = number.map(_.take(3))

    val prettyPrint: Option[String] = number.map{ x =>
        val area = areaCode.get
        val prefix = x slice (3, 6)
        val suffix = x drop 6

        s"""($area) $prefix-$suffix"""
    }
}
