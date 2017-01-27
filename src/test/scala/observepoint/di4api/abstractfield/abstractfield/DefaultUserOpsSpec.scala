package observepoint.di4api.abstractfield.abstractfield

import observepoint.di4api.abstractfield.data.UserData
import observepoint.di4api.abstractfield.ops.DefaultUserOps
import org.mockito.Mockito.when
import org.scalatest.FunSpec
import org.scalatest.Matchers._
import org.scalatest.mockito.MockitoSugar._


/**
  * Mocking example
  */
class DefaultUserOpsSpec extends FunSpec {

  describe(".get()") {
    it("should return username") {
      val userId = 1
      val userName = "super user"

      val ops = new DefaultUserOps {
        override val userData: UserData = mock[UserData]
      }

      when(ops.userData.get(userId)).thenReturn(userName)

      ops.get(userId) shouldEqual userName
    }
  }
}


