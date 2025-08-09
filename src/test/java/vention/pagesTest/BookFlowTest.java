package vention.pagesTest;

import vention.steps.BookingSteps;
import org.testng.annotations.Test;
import org.testng.Assert;

public class BookFlowTest extends BaseTest {
  private final BookingSteps bookingSteps = new BookingSteps();

  @Test
  public void testBookFlight() {
    bookingSteps.bookOneWayFlight(FARE_TYPE_ONE_WAY, DEPARTURE_DATE);
    Assert.assertTrue(bookingSteps.isUserRedirectedToOutboundPage(OUTBOUND_URL),
        "User should be redirected to outbound page after booking a flight");
  }
}
