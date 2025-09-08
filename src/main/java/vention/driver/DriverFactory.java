package vention.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
  public static WebDriver createLocalDriver(BrowserType browser) {
    WebDriver driver = switch (browser) {
      case CHROME -> getChromeDriver();
      case FIREFOX -> getFirefoxDriver();
      default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
    };
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

  public enum BrowserType {
    CHROME, FIREFOX
  };
}
