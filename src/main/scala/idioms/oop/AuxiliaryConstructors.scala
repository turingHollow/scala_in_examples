package idioms.oop

import idioms.oop.OpaqueTypes.Salary

object AuxiliaryConstructors {

  case class ZipCodeApply(zip: Int, extension: Int = 0):
    override def toString =
      if extension != 0 then s"$zip-$extension" else zip.toString

  object ZipCodeApply:
    def apply(zip: String, extension: String): ZipCodeApply =
      apply(zip.toInt, if extension.isEmpty then 0 else extension.toInt)
    def apply(zip: String): ZipCodeApply = apply(zip, "")

  @main def auxiliaryConstructorsMain() =
    println(ZipCodeApply("123"))

}
