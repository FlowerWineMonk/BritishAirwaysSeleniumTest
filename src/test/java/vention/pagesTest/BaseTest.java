package vention.pagesTest;

import vention.driver.DriverFactory;
import vention.driver.DriverManager;
import vention.entity.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BaseTest {
  protected static final String OUTBOUND_URL = "/airselect";
  protected static final String ANOTHER_OUTBOUND_URL = "/flightList";
  protected static final String FARE_TYPE_ONE_WAY = "oneWay";
  protected static final String TITLE_VALUE = "Mr";
  protected static final String COUNTRY_CODE_VALUE = "+1";
  protected static final String CONFIRMATION_URL = "/confirmation";
  protected static final String DEPARTURE_DATE = "calendar-day-" +
      LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

  protected User existingUser;
  protected User newUser;

  @BeforeClass
  public void beforeClass() {
    DriverManager.setDriver(DriverFactory.createInstance());
    existingUser = UserFactory.getExistingUser();
    newUser = UserFactory.getRandomUser();
  }

  @AfterClass
  public void afterClass() {
    DriverManager.quitDriver();
  }
}
