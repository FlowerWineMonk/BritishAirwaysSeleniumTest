package vention.pagesTest;

import vention.configLoader.ConfigLoader;
import vention.driver.DriverManager;
import vention.pages.CookiePopupPage;
import vention.pages.HomePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageLearnMoreTest extends BaseTest {
  private CookiePopupPage cookiePopupPage;
  private HomePage homePage;

  @BeforeMethod
  public void beforeMethod() {
    String url = ConfigLoader.get("home-url");
    DriverManager.getDriver().get(url);

    cookiePopupPage = new CookiePopupPage();
    cookiePopupPage.clickRejectAllBtn();

    homePage = new HomePage();
  }

  @Test
  public void testLearnMoreBtn() {
    SoftAssert softAssert = new SoftAssert();

    softAssert.assertTrue(homePage.isLearnMoreBtnDisplayed(), "Learn more button should be displayed on the 4th slide");
    String actualUrl = DriverManager.getDriver().getCurrentUrl();

    String beforeUrl = DriverManager.getDriver().getCurrentUrl();
    homePage.clickLearnMoreBtn();

    String afterUrl = DriverManager.getDriver().getCurrentUrl();
    softAssert.assertNotEquals(afterUrl, beforeUrl, "User should be redirected to a new page");

    softAssert.assertAll();
  }
}
