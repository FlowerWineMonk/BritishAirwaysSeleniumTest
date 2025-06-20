package vention.pagesTest;

import vention.configLoader.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
  @Test
  public void testLoginPageFunctionality() {
    Assert.assertTrue(loginPage.isEmailFieldDisplayed(), "Email field should be visible");
    Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field should be visible");
    //Assert.assertTrue(loginPage.isCaptchaFieldDisplayed(), "Captcha field should be visible");
    Assert.assertTrue(loginPage.isNextBtnDisplayed(), "Next button should be visible");

    String email = ConfigLoader.get("email");
    String password = ConfigLoader.get("password");
    loginPage.fillLoginCredentials(email, password);
    //loginPage.clickCaptchaField();
    loginPage.clickNextBtn();
  }
}
