package vention.steps;

import vention.pages.*;
import vention.entity.User;
import vention.entity.UserFactory;

public class RegistrationSteps {
  public void registerNewUserFlow() {
    PreLoginPage preLoginPage = new PreLoginPage();
    preLoginPage.openPage();

    CookiePopup cookiePopup = new CookiePopup();
    if (cookiePopup.isRejectAllButtonDisplayed()) {
      cookiePopup.clickRejectAllButton();
    }

    preLoginPage.clickRegisterButton();

    RegisterPage registerPage = new RegisterPage();
    User newUser = UserFactory.getRandomUser();
    registerPage.enterRegisterCredentials(newUser);
    registerPage.clickContinueButton();

    AccountSelectionPage accountSelectionPage = new AccountSelectionPage();
    accountSelectionPage.clickContinueButton();

    CreateProfilePage createProfilePage = new CreateProfilePage();
    createProfilePage.selectTitle("Mr");
    createProfilePage.enterNameCredentials(newUser);
    createProfilePage.selectCountryCode("+1");
    createProfilePage.enterPhoneNumber(newUser);
    createProfilePage.clickRegisterButton();
  }

  public boolean isHomePageVisibleAfterRegistration() {
    HomePage homePage = new HomePage();
    return homePage.isPageOpened();
  }
}
