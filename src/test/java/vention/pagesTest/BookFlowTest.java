package vention.pagesTest;

import vention.steps.BookingSteps;
import vention.enums.Cities;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.qameta.allure.*;

@Epic("Flight Booking")
@Feature("One-way flight booking")
public class BookFlowTest extends BaseTest {
  private final BookingSteps bookingSteps = new BookingSteps();

  @Test
  @Story("User books a one-way flight from New York to London")
  @Severity(SeverityLevel.CRITICAL)
  @Description("This test verifies that when a user books a one-way flight from New York (JFK) to London (LHR) " +
      "with the given departure date, the system redirects the user to the outbound flight selection page.")
  public void testBookFlight() {
    bookingSteps.bookOneWayFlight(FARE_TYPE_ONE_WAY,
        Cities.NEW_YORK.getCityName(),
        Cities.NEW_YORK.getCityAirport(),
        Cities.LONDON.getCityName(),
        Cities.LONDON.getCityAirport(),
        DEPARTURE_DATE);

    Assert.assertTrue(bookingSteps.isUserRedirectedToOutboundPage(OUTBOUND_URL),
        "User should be redirected to outbound page after booking a flight");
  }
}
