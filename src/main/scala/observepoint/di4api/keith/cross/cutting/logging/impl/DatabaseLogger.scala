package observepoint.di4api.keith.cross.cutting.logging.impl

import java.sql.Connection
import java.util.concurrent.ConcurrentLinkedQueue

import scala.concurrent.{ExecutionContext, Future}

/**
  * A database logger that inserts messages into a schema.
  * @param connection A database connection
  */
class DatabaseLogger(implicit val executionContext: ExecutionContext, val connection: Connection) extends Logger {

  //pretend we have a thread that flushes these to disk at a reasonable interval
  /**
    * queue up message to dump to disk
    */
  private lazy val mailbox = new ConcurrentLinkedQueue[Message]()

   def debug(message: String): Future[Unit] = Future { mailbox.add(Message(message, "debug")) }

   def info(message: String): Future[Unit] = Future { mailbox.add(Message(message, "debug")) }

   def warning(message: String): Future[Unit] = Future { mailbox.add(Message(message, "debug")) }

   def error(exception: Exception, message: Option[String]): Future[Unit] = Future { mailbox.add(Message(message.getOrElse(exception.getMessage), "debug")) }

}
