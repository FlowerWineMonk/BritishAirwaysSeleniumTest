package vention.pagesTest;

import vention.driver.DriverManager;
import vention.entity.User;
import vention.entity.UserFactory;
import vention.pages.CookiePopup;
import vention.pages.PreLoginPage;
import vention.pages.RegisterPage;
import vention.pages.AccountSelectionPage;
import vention.pages.CreateProfilePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class RegistrationFlowTest extends BaseTest {
  private static final String SELECT_TITLE = "Mr";
  private static final String SELECT_COUNTRY_CODE = "+1";
  private static final String PRE_LOGIN_URL = "/pre-login";
  private static final String REGISTER_URL = "/email-validation";
  private static final String ACCOUNT_SELECTION_URL = "/account-selection";
  private static final String CREATE_PROFILE_URL = "/register";
  private static final String HOME_URL = "/home";

  private CookiePopup cookiePopup;
  private PreLoginPage preLoginPage;
  private RegisterPage registerPage;
  private AccountSelectionPage accountSelectionPage;
  private CreateProfilePage createProfilePage;

  @Test
  public void testCompleteUserRegistrationFlowWithProfileCreation() {
    preLoginPage = new PreLoginPage();
    preLoginPage.openPage();

    final String actualUrl = DriverManager.getDriver().getCurrentUrl();
    Assert.assertTrue(actualUrl.contains(PRE_LOGIN_URL), "User should be in pre-login page");

    cookiePopup = new CookiePopup();
    Assert.assertTrue(cookiePopup.isRejectAllButtonDisplayed(), "Cookie popup should be visible during pre-login page with a reject all button");
    cookiePopup.clickRejectAllButton();

    SoftAssert preLoginSoftAssert = new SoftAssert();
    preLoginSoftAssert.assertTrue(preLoginPage.isLoginButtonDisplayed(), "Login button should be visible during pre-login page");
    preLoginSoftAssert.assertTrue(preLoginPage.isRegisterButtonDisplayed(), "Register button should be visible during pre-login page");
    preLoginSoftAssert.assertAll();

    preLoginPage.clickRegisterButton();
    final String actualUrlAfterPreLogin = DriverManager.getDriver().getCurrentUrl();
    Assert.assertTrue(actualUrlAfterPreLogin.contains(REGISTER_URL), "User should be redirected to the register page after pre-login page");

    User newUser = UserFactory.getRandomUser();
    registerPage = new RegisterPage();
    SoftAssert registerSoftAssert = new SoftAssert();
    registerSoftAssert.assertTrue(registerPage.isEmailInputDisplayed(), "Email input should be visible during register page");
    registerSoftAssert.assertTrue(registerPage.isPasswordInputDisplayed(), "Password input should be visible during register page");
    registerSoftAssert.assertTrue(registerPage.isContinueButtonDisplayed(), "Continue button should be visible during register page");
    registerSoftAssert.assertAll();

    registerPage.enterRegisterCredentials(newUser);
    registerPage.clickContinueButton();

    final String actualUrlAfterRegister = DriverManager.getDriver().getCurrentUrl();
    Assert.assertTrue(actualUrlAfterRegister.contains(ACCOUNT_SELECTION_URL), "User should be redirected to the account selection page after register page");

    accountSelectionPage = new AccountSelectionPage();
    Assert.assertTrue(accountSelectionPage.isContinueButtonDisplayed(), "Continue button should be visible during account selection page");
    accountSelectionPage.clickContinueButton();

    final String actualUrlAfterAccountSelection = DriverManager.getDriver().getCurrentUrl();
    Assert.assertTrue(actualUrlAfterAccountSelection.contains(CREATE_PROFILE_URL), "User should be redirected to the create profile page after account selection page");

    createProfilePage = new CreateProfilePage();
    SoftAssert loginSoftAssert = new SoftAssert();
    loginSoftAssert.assertTrue(createProfilePage.isTitleDropdownDisplayed(), "Title dropdown should be visible during create profile page");
    loginSoftAssert.assertTrue(createProfilePage.isFirstNameInputDisplayed(), "First name input should be visible during create profile page");
    loginSoftAssert.assertTrue(createProfilePage.isLastNameInputDisplayed(), "Last name input should be visible during create profile page");
    loginSoftAssert.assertTrue(createProfilePage.isCountryCodeDropdownDisplayed(), "Country code dropdown should be visible during create profile page");
    loginSoftAssert.assertTrue(createProfilePage.isPhoneNumberInputDisplayed(), "Phone number input should be visible during create profile page");
    loginSoftAssert.assertTrue(createProfilePage.isRegisterButtonDisplayed(), "Register button should be visible during create profile page");
    loginSoftAssert.assertAll();

    createProfilePage.selectTitle(SELECT_TITLE);
    createProfilePage.enterNameCredentials(newUser);
    createProfilePage.selectCountryCode(SELECT_COUNTRY_CODE);
    createProfilePage.enterPhoneNumber(newUser);
    createProfilePage.clickRegisterButton();

    final String actualUrlAfterProfileCreation = DriverManager.getDriver().getCurrentUrl();
    Assert.assertTrue(actualUrlAfterProfileCreation.contains(HOME_URL),  "User should be redirected to the home page after registration");
  }
}
