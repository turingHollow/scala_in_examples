@main def hello() = println("Hello, world")

sealed trait Expression

case class Value(v: Int) extends Expression
case class Add(e1: Expression, e2: Expression) extends Expression
case class Mult(l: Expression, e2: Expression) extends Expression

val expr = Mult(Add(Value(1), Value(2)), Value(3))
