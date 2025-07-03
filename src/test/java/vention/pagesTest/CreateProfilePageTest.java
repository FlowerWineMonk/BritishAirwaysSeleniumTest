package vention.pagesTest;

import vention.entity.User;
import vention.entity.UserFactory;
import vention.pages.CreateProfilePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class CreateProfilePageTest extends BaseTest {
  private CreateProfilePage createProfilePage;

  @Test
  public void enterProfileCredentialsTest() {
    User newUser = UserFactory.getRandomUser();
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
  }
}
