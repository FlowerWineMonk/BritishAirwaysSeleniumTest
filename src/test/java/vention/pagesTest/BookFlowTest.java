package vention.pagesTest;

import vention.configLoader.ConfigLoader;
import vention.driver.DriverManager;
import vention.pages.CookiePopup;
import vention.pages.HomePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class BookFlowTest extends BaseTest {
  private CookiePopup cookiePopup;
  private HomePage homePage;

  @BeforeMethod
  public void beforeMethod() {
    homePage = new HomePage();
    homePage.openPage();

    cookiePopup = new CookiePopup();
    cookiePopup.clickRejectAllButton();
  }

  @Test
  public void testBookFlight() {
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(homePage.isSelectFareDisplayed(), "Fare dropdown should be visible");
    softAssert.assertTrue(homePage.isFromInputDisplayed(), "From input should be visible");
    softAssert.assertTrue(homePage.isToInputDisplayed(), "To input should be visible");
    softAssert.assertTrue(homePage.isDepartureDateButtonDisplayed(), "Departure date button should be visible");
    softAssert.assertTrue(homePage.isFindFlightsButtonDisplayed(), "Find flights button should be visible");
    softAssert.assertAll();

    homePage.selectFare("oneWay");
    homePage.enterFromDestination(("New York"), ("new-york,-john-f-kennedy-(ny)-(jfk),-usa"));
    homePage.enterToDestination(("London"), ("london,-gatwick-(lgw),-united-kingdom"));
    homePage.selectDepartureDate("calendar-day-30/06/2025");

    final String beforeUrl = DriverManager.getDriver().getCurrentUrl();
    homePage.clickFindFlightsButton();
    final String afterUrl = DriverManager.getDriver().getCurrentUrl();
    Assert.assertNotEquals(afterUrl, beforeUrl, "User should be redirected to outbound page after booking a flight");
  }
}
