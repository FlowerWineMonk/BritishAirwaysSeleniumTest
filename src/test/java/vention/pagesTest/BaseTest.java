package vention.pagesTest;

import vention.configLoader.ConfigLoader;
import vention.driver.DriverFactory;
import vention.driver.DriverManager;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
  @BeforeClass
  public void beforeClass() {
    String browser = ConfigLoader.get("browser");
    DriverManager.setDriver(DriverFactory.createLocalDriver(browser));
  }

  @AfterClass
  public void afterClass() {
    DriverManager.quitDriver();
  }
}
