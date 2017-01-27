package observepoint.di4api.cake.data

import java.sql.Connection

/**
  * Persistence-layer component
  */
trait UserDataComponent {

  def userData: UserData

  trait UserData {
    def get(id: Int): String
  }
}

trait MysqlUserDataComponent extends UserDataComponent {

  class MysqlUserData(c: Connection) extends UserData {
    override def get(id: Int): String = "some user"
  }
}
