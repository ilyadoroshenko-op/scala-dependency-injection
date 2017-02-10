package observepoint.di4api.keith.cross.cutting.logging

import observepoint.di4api.keith.cross.cutting.logging.impl.Logger

/**
  * Concrete logger that will broadcast out to all loggers
  *
  * @param loggers A collection of concrete logging sinks
  */
class LoggingAppender(val loggers: Iterable[Logger]) extends LoggingAdapter {

  def debug(message: String): Unit = loggers.foreach(_.debug(message))

  def info(message: String): Unit = loggers.foreach(_.info(message))

  def warning(message: String): Unit = loggers.foreach(_.warning(message))

  def error(exception: Exception, message: Option[String]): Unit = loggers.foreach(_.error(exception, message))

}
