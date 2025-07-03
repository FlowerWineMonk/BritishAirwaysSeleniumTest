package vention.pagesTest;

import vention.pages.PreLoginPage;
import vention.pages.CookiePopup;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class PreLoginPageTest extends BaseTest {
  private PreLoginPage preLoginPage;
  private CookiePopup cookiePopup;

  @Test
  public void clickLoginButtonTest() {
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
    preLoginPage.clickLoginButton();
  }

  @Test
  public void clickRegisterButtonTest() {
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
  }
}
