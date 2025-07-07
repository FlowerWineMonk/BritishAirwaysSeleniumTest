package vention.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
  private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

  public static WebDriver getDriver() {
    return threadLocalDriver.get();
  }

  public static void setDriver(WebDriver driver) {
    threadLocalDriver.set(driver);
  }

  public static void quitDriver() {
    if(threadLocalDriver.get() != null) {
      threadLocalDriver.get().quit();
      threadLocalDriver.remove();
    }
  }
}
