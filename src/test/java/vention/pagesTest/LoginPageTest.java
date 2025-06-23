package vention.pagesTest;

import vention.configLoader.ConfigLoader;
import vention.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginPageTest extends BaseTest {
  @Test
  public void testLoginPageFunctionality() {
    SoftAssert softAssert = new SoftAssert();

    softAssert.assertTrue(loginPage.isEmailFieldDisplayed(), "Email field should be visible");
    softAssert.assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field should be visible");
    softAssert.assertTrue(loginPage.isNextBtnDisplayed(), "Next button should be visible");

    String email = ConfigLoader.get("email");
    String password = ConfigLoader.get("password");

    loginPage.fillLoginCredentials(email, password);
    loginPage.clickNextBtn();

    String expectedUrl = ConfigLoader.get("home-url");
    String actualUrl = DriverManager.getDriver().getCurrentUrl();

    softAssert.assertEquals(actualUrl, expectedUrl, "User should be redirected to the home page afrer login");

    softAssert.assertAll();
  }
}
