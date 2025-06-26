package vention.pagesTest;

import vention.configLoader.ConfigLoader;
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
  private CookiePopup cookiePopup;
  private PreLoginPage preLoginPage;
  private RegisterPage registerPage;
  private AccountSelectionPage accountSelectionPage;
  private CreateProfilePage createProfilePage;

  @BeforeMethod
  public void beforeMethod() {
    preLoginPage = new PreLoginPage();
    preLoginPage.openPage();

    cookiePopup = new CookiePopup();
    cookiePopup.clickRejectAllButton();

    preLoginPage.clickRegisterButton();

    registerPage = new RegisterPage();
    registerPage.enterRegisterCredentials(ConfigLoader.get("newEmail"), ConfigLoader.get("newPassword"));
    registerPage.clickContinueButton();

    accountSelectionPage = new AccountSelectionPage();
    accountSelectionPage.clickContinueButton();

    createProfilePage = new CreateProfilePage();
  }

  @Test
  public void testCompleteUserRegistrationFlowWithProfileCreation() {
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(createProfilePage.isTitleDropdownDisplayed(), "Title dropdown should be visible");
    softAssert.assertTrue(createProfilePage.isFirstNameInputDisplayed(), "First name input should be visible");
    softAssert.assertTrue(createProfilePage.isLastNameInputDisplayed(), "Last name input should be visible");
    softAssert.assertTrue(createProfilePage.isCountryCodeDropdownDisplayed(), "Country code dropdown should be visible");
    softAssert.assertTrue(createProfilePage.isPhoneNumberInputDisplayed(), "Phone number input should be visible");
    softAssert.assertTrue(createProfilePage.isRegisterButtonDisplayed(), "Register button should be visible");
    softAssert.assertAll();

    User newUser = UserFactory.createRandomUser();
    createProfilePage.selectTitle("Mr");
    createProfilePage.enterNameCredentials(newUser.getUsername(), newUser.getPassword());
    createProfilePage.selectCountryCode("+1");
    createProfilePage.enterPhoneNumber(newUser.getPhone());
    createProfilePage.clickRegisterButton();

    final String actualUrl = DriverManager.getDriver().getCurrentUrl();
    final String expectedUrl = "https://www.britishairways.com/travel/home/public/en_us/";
    Assert.assertEquals(actualUrl, expectedUrl, "User should be redirected to the home page after registration");
  }
}
