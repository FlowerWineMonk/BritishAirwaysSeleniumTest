package vention.steps;

import vention.pages.*;
import vention.entity.User;
import io.qameta.allure.Step;

public class RegistrationSteps {
  @Step("Register new user {user.email} with title '{title}' and country code '{countryCode}'")
  public void registerNewUserFlow(User user, String title, String countryCode) {
    PreLoginPage preLoginPage = new PreLoginPage();
    preLoginPage.openPage();

    CookiePopup cookiePopup = new CookiePopup();
    if (cookiePopup.isRejectAllButtonDisplayed()) {
      cookiePopup.clickRejectAllButton();
    }

    preLoginPage.clickRegisterButton();

    RegisterPage registerPage = new RegisterPage();
    registerPage.enterRegisterCredentials(user);
    registerPage.clickContinueButton();

    AccountSelectionPage accountSelectionPage = new AccountSelectionPage();
    accountSelectionPage.clickContinueButton();

    CreateProfilePage createProfilePage = new CreateProfilePage();
    createProfilePage.selectTitle(title);
    createProfilePage.enterNameCredentials(user);
    createProfilePage.selectCountryCode(countryCode);
    createProfilePage.enterPhoneNumber(user);
    createProfilePage.clickRegisterButton();
  }

  @Step("Verify home page is visible after registration")
  public boolean isHomePageVisibleAfterRegistration() {
    HomePage homePage = new HomePage();
    return homePage.isPageOpened();
  }
}
