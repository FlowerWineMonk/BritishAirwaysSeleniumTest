package vention.pagesTest;

import vention.driver.DriverManager;
import vention.pages.CookiePopup;
import vention.pages.HomePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class BookFlowTest extends BaseTest {
  private static final String FARE_TYPE_ONE_WAY = "oneWay";
  private static final String FROM_CITY_NAME = "New York";
  private static final String FROM_CITY_CODE = "new-york,-john-f-kennedy-(ny)-(jfk),-usa";
  private static final String TO_CITY_NAME = "London";
  private static final String TO_CITY_CODE = "london,-gatwick-(lgw),-united-kingdom";
  private static final String DEPARTURE_DATE = "calendar-day-31/08/2025";
  private static final String HOME_URL = "/home";

  private CookiePopup cookiePopup;
  private HomePage homePage;

  @Test
  public void testBookFlight() {
    homePage = new HomePage();
    homePage.openPage();

    final String actualUrl = DriverManager.getDriver().getCurrentUrl();
    Assert.assertTrue(actualUrl.contains(HOME_URL), "User should be in home page");

    cookiePopup = new CookiePopup();

    if (cookiePopup.isRejectAllButtonDisplayed()) {
      cookiePopup.clickRejectAllButton();
    }

    SoftAssert loginSoftAssert = new SoftAssert();
    loginSoftAssert.assertTrue(homePage.isSelectFareDisplayed(), "Fare dropdown should be visible during booking in home page");
    loginSoftAssert.assertTrue(homePage.isFromInputDisplayed(), "From input should be visible during booking in home page");
    loginSoftAssert.assertTrue(homePage.isToInputDisplayed(), "To input should be visible during booking in home page");
    loginSoftAssert.assertTrue(homePage.isDepartureDateButtonDisplayed(), "Departure date button should be visible during booking in home page");
    loginSoftAssert.assertTrue(homePage.isFindFlightsButtonDisplayed(), "Find flights button should be visible during booking in home page");
    loginSoftAssert.assertAll();

    homePage.selectFare(FARE_TYPE_ONE_WAY);
    homePage.enterFromDestination(FROM_CITY_NAME, FROM_CITY_CODE);
    homePage.enterToDestination(TO_CITY_NAME, TO_CITY_CODE);
    homePage.selectDepartureDate(DEPARTURE_DATE);

    final String beforeUrl = DriverManager.getDriver().getCurrentUrl();
    homePage.clickFindFlightsButton();
    final String afterUrl = DriverManager.getDriver().getCurrentUrl();
    Assert.assertNotEquals(afterUrl, beforeUrl, "User should be redirected to outbound page after booking a flight");
  }
}
