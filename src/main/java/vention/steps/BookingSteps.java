package vention.steps;

import vention.customWebElement.WebElementImp;
import vention.pages.CookiePopup;
import vention.pages.HomePage;
import io.qameta.allure.Step;

public class BookingSteps {
  @Step("Book one-way flight from {fromCity} ({fromAirport}) to {toCity} ({toAirport}) on {departureDate} with fare type {fareType}")
  public void bookOneWayFlight(String fareType, String fromCity, String fromAirport, String toCity, String toAirport,
      String departureDate) {
    HomePage homePage = new HomePage();
    homePage.openPage();

    CookiePopup cookiePopup = new CookiePopup();
    if (cookiePopup.isRejectAllButtonDisplayed()) {
      cookiePopup.clickRejectAllButton();
    }

    homePage.selectFare(fareType);
    homePage.enterFromDestination(fromCity, fromAirport);
    homePage.enterToDestination(toCity, toAirport);
    homePage.selectDepartureDate(departureDate);
    homePage.clickFindFlightsButton();
  }

  @Step("Verify user is redirected to outbound page containing: {outboundUrl} or {anotherOutboundUrl}")
  public boolean isUserRedirectedToOutboundPage(String outboundUrl, String anotherOutboundUrl) {
    return WebElementImp.waitForUrlContains(outboundUrl, 10)
        || WebElementImp.waitForUrlContains(anotherOutboundUrl, 10);
  }
}
