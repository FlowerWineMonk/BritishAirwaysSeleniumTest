package vention.pagesTest;

import vention.configLoader.ConfigLoader;
import vention.driver.DriverManager;
import vention.pages.CookiePopupPage;
import vention.pages.PreLoginPage;
import vention.pages.RegisterPage;
import vention.pages.AccountSelectionPage;
import vention.pages.CreateProfilePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegistrationFlowTest extends BaseTest {
  private CookiePopupPage cookiePopupPage;
  private PreLoginPage preLoginPage;
  private RegisterPage registerPage;
  private AccountSelectionPage accountSelectionPage;
  private CreateProfilePage createProfilePage;

  @BeforeMethod
  public void beforeMethod() {
    String url = ConfigLoader.get("pre-login-url");
    DriverManager.getDriver().get(url);

    cookiePopupPage = new CookiePopupPage();
    cookiePopupPage.clickRejectAllBtn();

    preLoginPage = new PreLoginPage();
    preLoginPage.clickRegisterBtn();

    registerPage = new RegisterPage();
    registerPage.fillRegisterCredentials(ConfigLoader.get("newEmail"), ConfigLoader.get("newPassword"));
    registerPage.clickContinueBtn();

    accountSelectionPage = new AccountSelectionPage();
    accountSelectionPage.clickContinueWithoutTheBritishAirwaysClubBtn();

    createProfilePage = new CreateProfilePage();
  }

  @Test
  public void testCompleteUserRegistrationFlowWithProfileCreation() {
    SoftAssert softAssert = new SoftAssert();

    softAssert.assertTrue(createProfilePage.isSelectTitleDisplayed(), "Select title should be visible");
    softAssert.assertTrue(createProfilePage.isFirstNameFieldDisplayed(), "First name field should be visible");
    softAssert.assertTrue(createProfilePage.isLastNameFieldDisplayed(), "Last name field should be visible");
    softAssert.assertTrue(createProfilePage.isSelectPhoneNumberDisplayed(), "Select phone number field should be visible");
    softAssert.assertTrue(createProfilePage.isPhoneNumberFieldDisplayed(), "Phone number field should be visible");
    softAssert.assertTrue(createProfilePage.isRegisterBtnDisplayed(), "Register button should be visible");

    createProfilePage.selectTitle(ConfigLoader.get("titleValue"));
    createProfilePage.fillNameCredentials(ConfigLoader.get("registrationFirstName"), ConfigLoader.get("registrationLastName"));
    createProfilePage.selectCountryCode(ConfigLoader.get("code"));
    createProfilePage.fillPhoneNumber(ConfigLoader.get("phoneNumber"));
    createProfilePage.clickRegisterBtn();

    String actualUrl = DriverManager.getDriver().getCurrentUrl();
    String expectedUrl = ConfigLoader.get("home-url");
    softAssert.assertEquals(actualUrl, expectedUrl, "User should be redirected to the home page after registration");
    softAssert.assertAll();
  }
}
