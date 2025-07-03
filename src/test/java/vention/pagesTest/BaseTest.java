package vention.pagesTest;

import vention.driver.DriverFactory;
import vention.driver.DriverManager;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
  protected static final String OUTBOUND_URL = "/book";
  protected static final String FARE_TYPE_ONE_WAY = "oneWay";
  protected static final String DEPARTURE_DATE = "calendar-day-31/08/2025";
  protected static final String TITLE_VALUE = "Mr";
  protected static final String COUNTRY_CODE_VALUE = "+1";

  @BeforeClass
  public void beforeClass() {
    DriverManager.setDriver(DriverFactory.createLocalDriver(DriverFactory.BrowserType.FIREFOX));
  }

  @AfterClass
  public void afterClass() {
    DriverManager.quitDriver();
  }
}
