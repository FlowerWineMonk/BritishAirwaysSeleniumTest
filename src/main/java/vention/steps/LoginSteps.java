package vention.steps;

import vention.entity.User;
import vention.pages.*;
import io.qameta.allure.Step;

public class LoginSteps {

  @Step("Login with user: email: {user.email} and password: {user.password}")
  public void loginWithExistingUser(User user) {
    PreLoginPage preLoginPage = new PreLoginPage();
    preLoginPage.openPage();

    CookiePopup cookiePopup = new CookiePopup();
    if (cookiePopup.isRejectAllButtonDisplayed()) {
      cookiePopup.clickRejectAllButton();
    }

    preLoginPage.clickLoginButton();

    LoginPage loginPage = new LoginPage();
    loginPage.enterLoginCredentials(user);
    loginPage.clickNextButton();
  }

  @Step("Verify home page is visible after login")
  public boolean isHomePageVisibleAfterLogin() {
    return new HomePage().isFromInputDisplayed();
  }
}
