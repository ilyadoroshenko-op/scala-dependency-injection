package observepoint.di4api.macwire

import java.sql.Connection

import observepoint.di4api.macwire.data.{MysqlUserData, UserData}
import observepoint.di4api.macwire.ops.{DefaultUserOps, UserOps}
import com.softwaremill.macwire._

/**
  * Injecting dependencies with MacWire
  *
  * + compile-time dependency resolving
  * + namespaces to avoid diamond problem
  * + automatic injection
  * + concise code
  *
  * - third-party library
  */
object MacWire extends App {

  lazy val conn: Connection = null

  lazy val userData: UserData = wire[MysqlUserData]

  lazy val userOps: UserOps = wire[DefaultUserOps]

  userOps.get(1)
}