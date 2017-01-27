package observepoint.di4api.abstractfield.ops

import observepoint.di4api.abstractfield.data.UserData

/**
  * Business logic layer
  */
trait UserOps {
  def get(id: Int): String
}

trait DefaultUserOps extends UserOps {

  def userData: UserData //require dependency via abstract field

  override def get(id: Int): String = userData.get(id) //use dependency
}
