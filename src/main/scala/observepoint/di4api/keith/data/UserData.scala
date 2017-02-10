package observepoint.di4api.keith.data

import java.sql.Connection

import observepoint.di4api.keith.cross.cutting.logging.LoggingAdapter

/**
  * Persistence-layer logic
  */
trait UserData {

  def connection: Connection

  def logger: LoggingAdapter

  def get(id: Int): String = ???
}

class MysqlUserData(val logger: LoggingAdapter)(implicit val connection: Connection) extends UserData {
}

