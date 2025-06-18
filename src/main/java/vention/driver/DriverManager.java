package vention.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
  private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

  public static WebDriver getDriver() {
    return threadLocalDriver.get();
  }

  public static void setDriver(WebDriver driver) {
    threadLocalDriver.set(driver);
  }

  public static void initDriver() {
    if(getDriver() == null) {
      ChromeOptions options = new ChromeOptions();
      options.setBinary("/opt/brave-bin/brave");
      WebDriver driver = new ChromeDriver(options);
      setDriver(driver);
    }
  }

  public static void quitDriver() {
    WebDriver driver = getDriver();
    if(driver != null) {
      driver.quit();
      threadLocalDriver.remove();
    }
  }
}
