package vention.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
  public static WebDriver createLocalDriver(BrowserType browser) {
    WebDriver driver = null;
    switch (browser) {
      case CHROME:
        driver = getChromeDriver();
        break;
      case FIREFOX:
        driver = getFirefoxDriver();
        break;
      default:
        throw new IllegalArgumentException("Unsupported browser: " + browser);
    }
    driver.manage().window().fullscreen();
    return driver;
  }

  private static WebDriver getChromeDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-fullscreen");
    return new ChromeDriver(options);
  }

  private static WebDriver getFirefoxDriver() {
    return new FirefoxDriver();
  }

  public enum BrowserType {CHROME, FIREFOX};
}
