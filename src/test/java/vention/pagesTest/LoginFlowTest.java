package vention.pagesTest;

import vention.pages.HomePage;
import vention.steps.LoginSteps;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginFlowTest extends BaseTest {
  private final LoginSteps loginSteps = new LoginSteps();

  @Test
  public void testCompleteUserLoginFlow() {
    loginSteps.loginWithExistingUser();

    HomePage homePage = new HomePage();
    Assert.assertTrue(homePage.isPageOpened(), "User should be redirected to the home page after login");
  }
}
