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
  private CookiePopup cookiePopup;
  private PreLoginPage preLoginPage;
  private LoginPage loginPage;

  @BeforeMethod
  public void beforeMethod() {
    preLoginPage = new PreLoginPage();
    preLoginPage.openPage();

    cookiePopup = new CookiePopup();
    cookiePopup.clickRejectAllButton();

    preLoginPage.clickLoginButton();

    loginPage = new LoginPage();
  }

  @Test
  public void testCompleteUserLoginFlow() {
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(loginPage.isEmailInputDisplayed(), "Email input should be visible");
    softAssert.assertTrue(loginPage.isPasswordInputDisplayed(), "Password input should be visible");
    softAssert.assertTrue(loginPage.isNextButtonDisplayed(), "Next button should be visible");
    softAssert.assertAll();
 
    User existingUser = UserFactory.getExistingUser();
    loginPage.enterLoginCredentials(existingUser.getEmail(), existingUser.getPassword());
    loginPage.clickNextButton();

    final String actualUrl = DriverManager.getDriver().getCurrentUrl();
    final String expectedUrl = "https://www.britishairways.com/travel/home/public/en_us/";
    Assert.assertEquals(actualUrl, expectedUrl, "User should be redirected to the home page after login");
  }
}
