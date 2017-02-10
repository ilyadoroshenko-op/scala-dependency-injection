package observepoint.di4api.keith.cross.cutting.logging

/**
  * Used to log diagnostic messages. Public API
  */
trait LoggingAdapter {
  def debug(message: String): Unit

  def info(message: String): Unit

  def warning(message: String): Unit

  def error(exception: Exception, message: Option[String] = None): Unit
}
