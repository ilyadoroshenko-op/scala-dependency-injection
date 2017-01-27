package observepoint.di4api.implicits

import observepoint.di4api.implicits.data.UserData
import observepoint.di4api.implicits.ops.DefaultUserOps
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
      implicit val userData = mock[UserData]
      when(userData.get(userId)).thenReturn(userName)
      val ops = new DefaultUserOps

      ops.get(userId) shouldEqual userName
    }
  }
}


