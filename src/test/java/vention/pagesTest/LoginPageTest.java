package vention.pagesTest;

import vention.entity.User;
import vention.entity.UserFactory;
import vention.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class LoginPageTest extends BaseTest {
  private LoginPage loginPage;

  @Test
  public void enterLoginCredentials() {
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
  }
}
