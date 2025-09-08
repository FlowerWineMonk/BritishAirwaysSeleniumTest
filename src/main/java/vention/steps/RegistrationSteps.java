package vention.steps;

import vention.pages.*;
import vention.entity.User;
import io.qameta.allure.Step;
import vention.utils.WaitUtils;

public class RegistrationSteps {

  @Step("Register new user with email: {user.email}, password: {user.password}, title: '{titleValue}', country code: '{countryCodeValue}', phone: {user.phone}, first name: {user.firstName}, last name: {user.lastName}")
  public void registerNewUser(String titleValue, User user, String countryCodeValue) {
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
    createProfilePage.selectTitle(titleValue);
    createProfilePage.enterNameCredentials(user);
    createProfilePage.selectCountryCode(countryCodeValue);
    createProfilePage.enterPhoneNumber(user);
    createProfilePage.clickRegisterButton();
  }

  @Step("Verify home page is visible after registration: {confirmationUrl}")
  public boolean isConfirmationPageVisibleAfterRegistration(String confirmationUrl) {
    return WaitUtils.waitForUrlContains(confirmationUrl, 10);
  }
}
