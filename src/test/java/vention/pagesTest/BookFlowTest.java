package vention.pagesTest;

import vention.configLoader.ConfigLoader;
import vention.driver.DriverManager;
import vention.pages.CookiePopupPage;
import vention.pages.HomePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BookFlowTest extends BaseTest {
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
  public void testBookFlight() {
    SoftAssert softAssert = new SoftAssert();

    softAssert.assertTrue(homePage.isSelectFareDisplayed(), "Select fare should be visible");
    softAssert.assertTrue(homePage.isFromFieldDisplayed(), "From field should be visible");
    softAssert.assertTrue(homePage.isToFieldDisplayed(), "To field should be visible");
    softAssert.assertTrue(homePage.isDepartureDateFieldDisplayed(), "Departure date field should be visible");
    softAssert.assertTrue(homePage.isFindFlightsBtnDisplayed(), "Find flights button should be visible");

    homePage.selectFare(ConfigLoader.get("fareWay"));
    homePage.fillFromField(ConfigLoader.get("fromCity"), ConfigLoader.get("fromCityInfo"));
    homePage.fillToField(ConfigLoader.get("toCity"), ConfigLoader.get("toCityInfo"));
    homePage.fillDepartureDateAndClick(ConfigLoader.get("departureDate"));

    String beforeUrl = DriverManager.getDriver().getCurrentUrl();
    homePage.clickFindFlightsBtn();

    String afterUrl = DriverManager.getDriver().getCurrentUrl();
    softAssert.assertNotEquals(afterUrl, beforeUrl, "User should be redirected to a new page");

    softAssert.assertAll();
  }
}
