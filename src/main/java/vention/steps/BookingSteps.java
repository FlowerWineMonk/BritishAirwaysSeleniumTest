package vention.steps;

import vention.driver.DriverManager;
import vention.pages.CookiePopup;
import vention.pages.HomePage;
import vention.enums.Cities;

public class BookingSteps {
  public void bookOneWayFlight(String fareType, String departureDate) {
    HomePage homePage = new HomePage();
    homePage.openPage();

    CookiePopup cookiePopup = new CookiePopup();
    if (cookiePopup.isRejectAllButtonDisplayed()) {
      cookiePopup.clickRejectAllButton();
    }

    homePage.selectFare(fareType);
    homePage.enterFromDestination(Cities.NEW_YORK.getCityName(), Cities.NEW_YORK.getCityAirport());
    homePage.enterToDestination(Cities.LONDON.getCityName(), Cities.LONDON.getCityAirport());
    homePage.selectDepartureDate(departureDate);
    homePage.clickFindFlightsButton();
  }

  public boolean isUserRedirectedToOutboundPage(String outboundUrl) {
    return DriverManager.getDriver().getCurrentUrl().contains(outboundUrl);
  }
}
