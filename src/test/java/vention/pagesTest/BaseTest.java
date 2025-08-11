package vention.pagesTest;

import vention.driver.DriverFactory;
import vention.driver.DriverManager;
import vention.entity.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
  protected static final String OUTBOUND_URL = "/airselect";
  protected static final String FARE_TYPE_ONE_WAY = "oneWay";
  protected static final String DEPARTURE_DATE = "calendar-day-30/09/2025";
  protected static final String TITLE_VALUE = "Mr";
  protected static final String COUNTRY_CODE_VALUE = "+1";

  protected User existingUser;
  protected User newUser;

  @BeforeClass
  public void beforeClass() {
    DriverManager.setDriver(DriverFactory.createLocalDriver(DriverFactory.BrowserType.FIREFOX));
    existingUser = UserFactory.getExistingUser();
    newUser = UserFactory.getRandomUser();
  }

  @AfterClass
  public void afterClass() {
    DriverManager.quitDriver();
  }
}
