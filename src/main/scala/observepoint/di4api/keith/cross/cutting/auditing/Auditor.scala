package observepoint.di4api.keith.cross.cutting.auditing

import observepoint.di4api.keith.model.User

/**
  * Used to for security logging of user interactions
  */
trait Auditor {

  def normal(user: User, message: Option[String]): Unit

  def restricted(user: User, message: Option[String]): Unit
}
