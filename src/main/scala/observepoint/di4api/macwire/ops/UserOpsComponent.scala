package observepoint.di4api.macwire.ops

import observepoint.di4api.macwire.data.UserData

/**
  * Business logic layer
  */
trait UserOps {
  def get(id: Int): String
}

class DefaultUserOps(userData: UserData) extends UserOps { //require dependency via constructor parameter

  override def get(id: Int): String = userData.get(id) //use dependency
}
