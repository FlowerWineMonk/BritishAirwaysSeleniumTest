package vention.pagesTest;

import vention.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginFlowTest extends BaseTest {
  private PreLoginPageTest preLoginPageTest;
  private LoginPageTest loginPageTest;
  private HomePage homePage;

  @Test
  public void testCompleteUserLoginFlow() {
    preLoginPageTest = new PreLoginPageTest();
    preLoginPageTest.clickLoginButtonTest();

    loginPageTest = new LoginPageTest();
    loginPageTest.enterLoginCredentials();

    homePage = new HomePage();
    Assert.assertTrue(homePage.isPageOpened(), "User should be redirected to the home page after login");
  }
}
