package observepoint.di4api.abstractfield.data

import java.sql.Connection

/**
  * Persistence-layer logic
  */
trait UserData {
  def get(id: Int): String
}

trait MysqlUserData extends UserData {

  def c: Connection

  override def get(id: Int): String = "some user"
}

