package observepoint.di4api.keith.ops

import observepoint.di4api.keith.cross.cutting.auditing.Auditor
import observepoint.di4api.keith.cross.cutting.logging.LoggingAdapter
import observepoint.di4api.keith.data.UserData

/**
  * Business logic layer
  */
trait UserOps {
  def userData: UserData

  def logger: LoggingAdapter

  def auditor: Auditor

  def get(id: Int): String
}

class DefaultUserOps(val userData: UserData, val logger: LoggingAdapter, val auditor: Auditor) extends UserOps {
  override def get(id: Int): String = ""
}
