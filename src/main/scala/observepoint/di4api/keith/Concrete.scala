package observepoint.di4api.keith

import java.sql.Connection

import observepoint.di4api.keith.cross.cutting.auditing.Auditor
import observepoint.di4api.keith.cross.cutting.logging.impl.{ConsoleLogger, DatabaseLogger}
import observepoint.di4api.keith.cross.cutting.logging.{LoggingAppender, impl}
import observepoint.di4api.keith.data.MysqlUserData
import observepoint.di4api.keith.model.User
import observepoint.di4api.keith.ops.DefaultUserOps


object Concrete extends App {

  implicit lazy val conn: Connection = null

  implicit lazy val executionContext = scala.concurrent.ExecutionContext.global

  lazy val consoleLogger = new ConsoleLogger()
  lazy val databaseLogger = new DatabaseLogger()
  lazy val loggingAdapter = new LoggingAppender(List(consoleLogger, databaseLogger))

  lazy val auditorAdapter = new Auditor {
    override def normal(user: User, message: Option[String]): Unit = ???

    override def restricted(user: User, message: Option[String]): Unit = ???
  }
  lazy val userData = new MysqlUserData(loggingAdapter)

  lazy val userOps = new DefaultUserOps(userData, loggingAdapter, auditorAdapter)

  userOps.get(1)
}

object Wired extends App {

  import com.softwaremill.macwire._

  implicit lazy val conn: Connection = null

  implicit lazy val executionContext = scala.concurrent.ExecutionContext.global

  lazy val auditorAdapter = new Auditor {
    override def normal(user: User, message: Option[String]): Unit = ""

    override def restricted(user: User, message: Option[String]): Unit = ""
  }


  lazy val consoleLogger = wire[ConsoleLogger] //looks for implicit parameters in scope
  lazy val databaseLogger = wire[DatabaseLogger]
  lazy val loggerSet = wireSet[impl.Logger] //works only with sets

  lazy val loggingAdapter = wire[LoggingAppender]

  lazy val userData = wire[MysqlUserData]

  lazy val userOps = wire[DefaultUserOps]

  userOps.get(1)
}
