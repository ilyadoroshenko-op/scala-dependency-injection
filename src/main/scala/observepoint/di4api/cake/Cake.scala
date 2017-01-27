package observepoint.di4api.cake

import java.sql.Connection

import observepoint.di4api.cake.data.MysqlUserDataComponent
import observepoint.di4api.cake.ops.DefaultUserOpsComponent

/**
  * Traditional Cake Pattern as described by Odersky and Boner
  *
  * + compile-time dependency resolving
  * + namespaces to avoid diamond problem
  * + automatic injection
  *
  * - lot of boilerplate
  */
object Cake extends App {

  lazy val c: Connection = null

  val api = new DefaultUserOpsComponent with MysqlUserDataComponent { //stacking the implementations to wire

    /* field instantiation */
    override val userData: UserData = new MysqlUserData(c)

    override val userOps: UserOps = new DefaultUserOps
  }

  api.userOps.get(1)
}