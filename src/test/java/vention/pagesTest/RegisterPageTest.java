package vention.pagesTest;

import vention.entity.User;
import vention.entity.UserFactory;
import vention.pages.RegisterPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class RegisterPageTest extends BaseTest {
  private RegisterPage registerPage;

  @Test
  public void enterRegisterCredentialsTest() {
    User newUser = UserFactory.getRandomUser();
    registerPage = new RegisterPage();
    Assert.assertTrue(registerPage.isPageOpened(), "User should be redirected to the register page after pre-login page");

    SoftAssert registerSoftAssert = new SoftAssert();
    registerSoftAssert.assertTrue(registerPage.isEmailInputDisplayed(), "Email input should be visible during register page");
    registerSoftAssert.assertTrue(registerPage.isPasswordInputDisplayed(), "Password input should be visible during register page");
    registerSoftAssert.assertTrue(registerPage.isContinueButtonDisplayed(), "Continue button should be visible during register page");
    registerSoftAssert.assertAll();
    registerPage.enterRegisterCredentials(newUser);
    registerPage.clickContinueButton();
  }
}
