package observepoint.di4api.cake

import observepoint.di4api.cake.data.UserDataComponent
import observepoint.di4api.cake.ops.{DefaultUserOpsComponent, UserOpsComponent}
import org.mockito.Mockito.when
import org.scalatest.FunSpec
import org.scalatest.Matchers._
import org.scalatest.mockito.MockitoSugar._


/**
  * Mocking example
  */
class DefaultUserOpsComponentSpec extends FunSpec with TestEnvironment with DefaultUserOpsComponent {

  describe(".get()") {
    it("should return username") {
      val userId = 1
      val userName = "super user"
      val ops = new DefaultUserOps
      when(userData.get(userId)).thenReturn(userName)

      ops.get(userId) shouldEqual userName
    }
  }
}

trait TestEnvironment extends UserOpsComponent with UserDataComponent {
  override val userOps: UserOps = mock[UserOps]
  override val userData: UserData = mock[UserData]
}


