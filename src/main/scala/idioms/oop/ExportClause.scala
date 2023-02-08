package idioms.oop

import java.net.URL

object ExportClause{

  case class UserName(value: String):
    assert(value.nonEmpty)

  case class Password(value: String):
    assert(value.nonEmpty)
  trait Authenticate:
    final def apply(username: UserName, password: Password): Boolean =
      auth(username, password)
    protected def auth(username: UserName, password: Password): Boolean

  class DirectoryAuthenticate(location: URL) extends Authenticate :
    protected def auth(username: UserName, password: Password): Boolean = true

  object Service:
    private val dirAuthenticate = DirectoryAuthenticate(URL("https://directory.wtf"))
    export dirAuthenticate.apply as authenticate

  @main def exportClauseMain() = println()

}
