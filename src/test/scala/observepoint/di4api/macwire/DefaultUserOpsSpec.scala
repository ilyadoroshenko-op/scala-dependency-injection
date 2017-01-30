package observepoint.di4api.macwire

import observepoint.di4api.macwire.data.UserData
import observepoint.di4api.macwire.ops.DefaultUserOps
import org.mockito.Mockito.when
import org.scalatest.FunSpec
import org.scalatest.Matchers._
import org.scalatest.mockito.MockitoSugar._
import com.softwaremill.macwire._


/**
  * Mocking example
  */
class DefaultUserOpsSpec extends FunSpec {

  describe(".get()") {
    it("should return username") {
      val userId = 1
      val userName = "super user"
      val userData = mock[UserData]
      when(userData.get(userId)).thenReturn(userName)
      val ops = wire[DefaultUserOps]

      ops.get(userId) shouldEqual userName
    }
  }
}


