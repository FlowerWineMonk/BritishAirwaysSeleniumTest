package vention.pagesTest;

import vention.configLoader.ConfigLoader;
import vention.driver.DriverManager;
import vention.pages.CookiePopupPage;
import vention.pages.PreLoginPage;
import vention.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginFlowTest extends BaseTest {
  private CookiePopupPage cookiePopupPage;
  private PreLoginPage preLoginPage;
  private LoginPage loginPage;

  @BeforeMethod
  public void beforeMethod() {
    String url = ConfigLoader.get("pre-login-url");
    DriverManager.getDriver().get(url);

    cookiePopupPage = new CookiePopupPage();
    cookiePopupPage.clickRejectAllBtn();

    preLoginPage = new PreLoginPage();
    preLoginPage.clickLoginBtn();

    loginPage = new LoginPage();
  }

  @Test
  public void testCompleteUserLoginFlow() {
    SoftAssert softAssert = new SoftAssert();

    softAssert.assertTrue(loginPage.isEmailFieldDisplayed(), "Email field should be visible");
    softAssert.assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field should be visible");
    softAssert.assertTrue(loginPage.isNextBtnDisplayed(), "Next button should be visible");
 
    loginPage.fillLoginCredentials(ConfigLoader.get("email"), ConfigLoader.get("password"));
    loginPage.clickNextBtn();

    String actualUrl = DriverManager.getDriver().getCurrentUrl();
    String expectedUrl = ConfigLoader.get("home-url");
    softAssert.assertEquals(actualUrl, expectedUrl, "User should be redirected to the home page after login");
    softAssert.assertAll();
  }
}
