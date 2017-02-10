package observepoint.di4api.keith.cross.cutting.logging.impl

import scala.concurrent.Future

/**
  * Used to log diagnostic messages. Private API
  */
trait Logger {

  def debug(message: String): Future[Unit]

  def info(message: String): Future[Unit]

  def warning(message: String): Future[Unit]

  def error(exception: Exception, message: Option[String] = None): Future[Unit]
}