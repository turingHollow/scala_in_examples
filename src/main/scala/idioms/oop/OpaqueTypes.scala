package idioms.oop

object OpaqueTypes {

  /* Preserve type safety and have zero run‐time overhead beyond the value they wrap */

  object Accounting:
    opaque type Dollars = Double
    opaque type Percentage = Double

    object Dollars:
      def apply(amount: Double): Dollars = amount
      extension (d: Dollars)
        def +(d2: Dollars): Dollars = d + d2
        def -(d2: Dollars): Dollars = d - d2
        def *(p: Percentage): Dollars = d * p
        def toDouble: Double = d

    object Percentage:
      def apply(amount: Double): Percentage = amount
      extension (p: Percentage)
        def +(p2: Percentage): Percentage = p + p2
        def -(p2: Percentage): Percentage = p - p2
        def *(d: Dollars): Dollars = d * p
        def toDouble: Double = p

  import Accounting.*
  case class Salary(gross: Dollars, taxes: Percentage):
    def net: Dollars = gross - (gross * taxes)

  @main def opaqueTypesMain() = println(
    Salary(
      gross = Dollars(30000.00),
      taxes = Percentage(0.2)
    ).net
  )

}
