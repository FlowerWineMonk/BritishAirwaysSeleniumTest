package vention.steps;

import vention.entity.User;
import vention.entity.UserFactory;
import vention.pages.*;

public class LoginSteps {
  public void loginWithExistingUser() {
    PreLoginPage preLoginPage = new PreLoginPage();
    preLoginPage.openPage();

    CookiePopup cookiePopup = new CookiePopup();
    if (cookiePopup.isRejectAllButtonDisplayed()) {
      cookiePopup.clickRejectAllButton();
    }

    preLoginPage.clickLoginButton();

    LoginPage loginPage = new LoginPage();
    User existingUser = UserFactory.getExistingUser();
    loginPage.enterLoginCredentials(existingUser);
    loginPage.clickNextButton();
  }

  public boolean isHomePageVisibleAfterRegistration() {
    HomePage homePage = new HomePage();
    return homePage.isPageOpened();
  }
}
