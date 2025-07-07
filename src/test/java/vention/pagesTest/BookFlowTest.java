package vention.pagesTest;

import vention.driver.DriverManager;
import vention.pages.CookiePopup;
import vention.pages.HomePage;
import vention.enums.Cities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class BookFlowTest extends BaseTest {
  private CookiePopup cookiePopup;
  private HomePage homePage;

  @Test
  public void testBookFlight() {
    homePage = new HomePage();
    homePage.openPage();

    cookiePopup = new CookiePopup();
    if (cookiePopup.isRejectAllButtonDisplayed()) {
      cookiePopup.clickRejectAllButton();
    }

    homePage.selectFare(FARE_TYPE_ONE_WAY);
    homePage.enterFromDestination(Cities.NEW_YORK.getCityName(), Cities.NEW_YORK.getCityAirport());
    homePage.enterToDestination(Cities.LONDON.getCityName(), Cities.LONDON.getCityAirport());
    homePage.selectDepartureDate(DEPARTURE_DATE);
    homePage.clickFindFlightsButton();

    final String currentUrl = DriverManager.getDriver().getCurrentUrl();
    Assert.assertTrue(currentUrl.contains(OUTBOUND_URL), "User should be redirected to outbound page after booking a flight");
  }
}
