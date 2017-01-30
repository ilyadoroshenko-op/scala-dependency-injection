package observepoint.di4api.macwire.data

import java.sql.Connection

/**
  * Persistence-layer logic
  */
trait UserData {
  def get(id: Int): String
}

class MysqlUserData(c: Connection) extends UserData {

  override def get(id: Int): String = "some user"
}

