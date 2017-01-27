package observepoint.di4api.abstractfield

import java.sql.Connection

import observepoint.di4api.abstractfield.data.{MysqlUserData, UserData}
import observepoint.di4api.abstractfield.ops.{DefaultUserOps, UserOps}

/**
  * Pure abstract field approach (sort of what we currently have in API)
  *
  * + compile-time dependency resolving
  * + namespaces to avoid diamond problem
  * + concise code
  *
  * - manual injection: tedious when lot of dependencies
  */
object AbstractField extends App { app =>

  lazy val conn: Connection = null

  lazy val userData: UserData = new MysqlUserData { //declaring a concrete impl
    override def c: Connection = conn
  }

  lazy val userOps: UserOps = new DefaultUserOps {
    override def userData: UserData = app.userData //manually injecting it
  }

  userOps.get(1)
}