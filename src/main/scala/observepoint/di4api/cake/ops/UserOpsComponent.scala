package observepoint.di4api.cake.ops

import observepoint.di4api.cake.data.UserDataComponent

/**
  * Business logic component
  */
trait UserOpsComponent {

  def userOps: UserOps //field for actual dependency

  trait UserOps {
    def get(id: Int): String
  }
}

trait DefaultUserOpsComponent extends UserOpsComponent {
  this: UserDataComponent => //require dependencies with self type

  class DefaultUserOps extends UserOps {
    override def get(id: Int): String = userData.get(id) //use dependency
  }
}
