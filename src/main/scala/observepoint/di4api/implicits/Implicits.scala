package observepoint.di4api.implicits

import java.sql.Connection

import observepoint.di4api.implicits.data.{MysqlUserData, UserData}
import observepoint.di4api.implicits.ops.{DefaultUserOps, UserOps}

/**
  * Injecting dependencies via implicit class parameters
  *
  * + compile-time dependency resolving
  * + namespaces to avoid diamond problem
  * + automatic injection
  * + concise code
  *
  * - need workaround for circular dependencies
  * - polluting implicit scope
  */
object Implicits extends App {

  implicit lazy val conn: Connection = null

  implicit lazy val userData: UserData = new MysqlUserData

  implicit lazy val userOps: UserOps = new DefaultUserOps

  userOps.get(1)
}