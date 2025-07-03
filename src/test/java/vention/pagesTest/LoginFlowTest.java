package vention.pagesTest;

import vention.entity.User;
import vention.entity.UserFactory;
import vention.pages.CookiePopup;
import vention.pages.HomePage;
import vention.pages.PreLoginPage;
import vention.pages.LoginPage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;


public class LoginFlowTest extends BaseTest {
  private CookiePopup cookiePopup;
  private PreLoginPage preLoginPage;
  private LoginPage loginPage;
  private HomePage homePage;

  @Test
  public void testCompleteUserLoginFlow() {
    preLoginPage = new PreLoginPage();
    preLoginPage.openPage();

    Assert.assertTrue(preLoginPage.isPageOpened(), "User should be in pre-login page");

    cookiePopup = new CookiePopup();
    if (cookiePopup.isRejectAllButtonDisplayed()) {
      cookiePopup.clickRejectAllButton();
    }

    SoftAssert preLoginSoftAssert = new SoftAssert();
    preLoginSoftAssert.assertTrue(preLoginPage.isLoginButtonDisplayed(), "Login button should be visible during pre-login page");
    preLoginSoftAssert.assertTrue(preLoginPage.isRegisterButtonDisplayed(), "Register button should be visible during pre-login page");
    preLoginSoftAssert.assertAll();
    preLoginPage.clickLoginButton();

    loginPage = new LoginPage();
    Assert.assertTrue(loginPage.isPageOpened(), "User should be redirected to the login page after pre-login page");

    SoftAssert loginSoftAssert = new SoftAssert();
    loginSoftAssert.assertTrue(loginPage.isEmailInputDisplayed(), "Email input should be visible during login");
    loginSoftAssert.assertTrue(loginPage.isPasswordInputDisplayed(), "Password input should be visible during login");
    loginSoftAssert.assertTrue(loginPage.isNextButtonDisplayed(), "Next button should be visible during login");
    loginSoftAssert.assertAll();
 
    User existingUser = UserFactory.getExistingUser();
    loginPage.enterLoginCredentials(existingUser);
    loginPage.clickNextButton();

    homePage = new HomePage();
    Assert.assertTrue(homePage.isPageOpened(), "User should be redirected to the home page after login");
  }
}
