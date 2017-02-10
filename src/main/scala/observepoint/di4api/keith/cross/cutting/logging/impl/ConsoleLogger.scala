package observepoint.di4api.keith.cross.cutting.logging.impl

import java.util.concurrent.ConcurrentLinkedQueue

import scala.concurrent.{ExecutionContext, Future}

/**
  * A console logger that appends formatted messages.
  */
class ConsoleLogger(implicit val executionContext: ExecutionContext) extends Logger {

  //pretend we have a thread that flushes these to the console at a reasonable interval
  /**
    * queue up message to dump to the console
    */
  private lazy val mailbox = new ConcurrentLinkedQueue[Message]()

  def debug(message: String): Future[Unit] = Future { mailbox.add(Message(message, "debug")) }

  def info(message: String): Future[Unit] = Future { mailbox.add(Message(message, "info")) }

  def warning(message: String): Future[Unit] = Future { mailbox.add(Message(message, "warning")) }

  def error(exception: Exception, message: Option[String]): Future[Unit] = Future { mailbox.add(Message(message.getOrElse(exception.getMessage), "debug")) }
}
