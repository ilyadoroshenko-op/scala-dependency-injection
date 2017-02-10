package observepoint.di4api.keith.cross.cutting.logging.impl

import java.time.LocalDateTime

case class Message(time: LocalDateTime, message: String, level: String)

object Message {
  def apply(message: String, level: String): Message = new Message(LocalDateTime.now(), message, level)
}