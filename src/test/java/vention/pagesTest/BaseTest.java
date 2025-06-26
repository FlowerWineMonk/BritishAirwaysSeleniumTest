package vention.pagesTest;

import vention.driver.DriverFactory;
import vention.driver.DriverManager;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
  @BeforeClass
  public void beforeClass() {
    DriverManager.setDriver(DriverFactory.createLocalDriver(DriverFactory.BrowserType.FIREFOX));
  }

  @AfterClass
  public void afterClass() {
    DriverManager.quitDriver();
  }
}
