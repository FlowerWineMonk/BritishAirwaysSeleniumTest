package vention.pagesTest;

import vention.entity.User;
import vention.entity.UserFactory;
import vention.pages.CookiePopup;
import vention.pages.HomePage;
import vention.pages.PreLoginPage;
import vention.pages.RegisterPage;
import vention.pages.AccountSelectionPage;
import vention.pages.CreateProfilePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class RegistrationFlowTest extends BaseTest {
  private CookiePopup cookiePopup;
  private PreLoginPage preLoginPage;
  private RegisterPage registerPage;
  private AccountSelectionPage accountSelectionPage;
  private CreateProfilePage createProfilePage;
  private HomePage homePage;

  @Test
  public void testCompleteUserRegistrationFlowWithProfileCreation() {
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
    preLoginPage.clickRegisterButton();

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

    accountSelectionPage = new AccountSelectionPage();
    Assert.assertTrue(accountSelectionPage.isPageOpened(), "User should be redirected to the account selection page after register page");
    Assert.assertTrue(accountSelectionPage.isContinueButtonDisplayed(), "Continue button should be visible during account selection page");
    accountSelectionPage.clickContinueButton();

    createProfilePage = new CreateProfilePage();
    Assert.assertTrue(createProfilePage.isPageOpened(), "User should be redirected to the create profile page after account selection page");

    SoftAssert loginSoftAssert = new SoftAssert();
    loginSoftAssert.assertTrue(createProfilePage.isTitleDropdownDisplayed(), "Title dropdown should be visible during create profile page");
    loginSoftAssert.assertTrue(createProfilePage.isFirstNameInputDisplayed(), "First name input should be visible during create profile page");
    loginSoftAssert.assertTrue(createProfilePage.isLastNameInputDisplayed(), "Last name input should be visible during create profile page");
    loginSoftAssert.assertTrue(createProfilePage.isCountryCodeDropdownDisplayed(), "Country code dropdown should be visible during create profile page");
    loginSoftAssert.assertTrue(createProfilePage.isPhoneNumberInputDisplayed(), "Phone number input should be visible during create profile page");
    loginSoftAssert.assertTrue(createProfilePage.isRegisterButtonDisplayed(), "Register button should be visible during create profile page");
    loginSoftAssert.assertAll();

    createProfilePage.selectTitle(TITLE_VALUE);
    createProfilePage.enterNameCredentials(newUser);
    createProfilePage.selectCountryCode(COUNTRY_CODE_VALUE);
    createProfilePage.enterPhoneNumber(newUser);
    createProfilePage.clickRegisterButton();

    homePage = new HomePage();
    Assert.assertTrue(homePage.isPageOpened(),  "User should be redirected to the home page after registration");
  }
}
