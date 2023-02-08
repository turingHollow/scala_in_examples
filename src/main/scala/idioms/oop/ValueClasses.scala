package idioms.oop

object ValueClasses {

  /* mechanism to eliminate the run‐time overhead of wrapper types */

  trait Digitizer extends Any :
    /* A universal trait is a trait that extends Any,
     only has defs as members, and does no initialization. */
    def digits(s: String): String = s.replaceAll("""\D""", "")

  class NAPhoneNumber(val s: String) extends AnyVal with Digitizer :

    override def toString: String =
      val digs = digits(s)
      val areaCode = digs.substring(0, 3)
      val exchange = digs.substring(3, 6)
      val subnumber = digs.substring(6, 10)
      s"($areaCode) $exchange-$subnumber"


  @main def valueClassesMain() = println(NAPhoneNumber("89999999999"))

}
