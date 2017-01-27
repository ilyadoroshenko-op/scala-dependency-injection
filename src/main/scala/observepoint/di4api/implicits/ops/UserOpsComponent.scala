package observepoint.di4api.implicits.ops

import observepoint.di4api.implicits.data.UserData

/**
  * Business logic layer
  */
trait UserOps {
  def get(id: Int): String
}

class DefaultUserOps(implicit userData: UserData) extends UserOps { //require dependency via implicit parameter

  override def get(id: Int): String = userData.get(id) //use dependency
}
