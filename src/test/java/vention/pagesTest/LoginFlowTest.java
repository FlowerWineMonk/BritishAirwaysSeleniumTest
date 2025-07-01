package vention.pagesTest;

import vention.driver.DriverManager;
import vention.entity.User;
import vention.entity.UserFactory;
import vention.pages.CookiePopup;
import vention.pages.PreLoginPage;
import vention.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;


public class LoginFlowTest extends BaseTest {
  private static final String PRE_LOGIN_URL = "/pre-login";
  private static final String LOGIN_URL = "/login";
  private static final String HOME_URL = "/home";

  private CookiePopup cookiePopup;
  private PreLoginPage preLoginPage;
  private LoginPage loginPage;

  @Test
  public void testCompleteUserLoginFlow() {
    preLoginPage = new PreLoginPage();
    preLoginPage.openPage();

    final String actualUrl = DriverManager.getDriver().getCurrentUrl();
    Assert.assertTrue(actualUrl.contains(PRE_LOGIN_URL), "User should be in pre-login page");

    cookiePopup = new CookiePopup();

    if (cookiePopup.isRejectAllButtonDisplayed()) {
      cookiePopup.clickRejectAllButton();
    }

    SoftAssert preLoginSoftAssert = new SoftAssert();
    preLoginSoftAssert.assertTrue(preLoginPage.isLoginButtonDisplayed(), "Login button should be visible during pre-login page");
    preLoginSoftAssert.assertTrue(preLoginPage.isRegisterButtonDisplayed(), "Register button should be visible during pre-login page");
    preLoginSoftAssert.assertAll();
    preLoginPage.clickLoginButton();

    final String actualUrlAfterPreLogin = DriverManager.getDriver().getCurrentUrl();
    Assert.assertTrue(actualUrlAfterPreLogin.contains(LOGIN_URL), "User should be redirected to the login page after pre-login page");

    loginPage = new LoginPage();
    SoftAssert loginSoftAssert = new SoftAssert();
    loginSoftAssert.assertTrue(loginPage.isEmailInputDisplayed(), "Email input should be visible during login");
    loginSoftAssert.assertTrue(loginPage.isPasswordInputDisplayed(), "Password input should be visible during login");
    loginSoftAssert.assertTrue(loginPage.isNextButtonDisplayed(), "Next button should be visible during login");
    loginSoftAssert.assertAll();
 
    User existingUser = UserFactory.getExistingUser();
    loginPage.enterLoginCredentials(existingUser);
    loginPage.clickNextButton();

    final String actualUrlAfterLogin = DriverManager.getDriver().getCurrentUrl();
    Assert.assertTrue(actualUrlAfterLogin.contains(HOME_URL), "User should be redirected to the home page after login");
  }
}
