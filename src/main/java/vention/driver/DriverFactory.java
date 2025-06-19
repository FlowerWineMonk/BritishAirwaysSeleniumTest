package vention.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
  private static WebDriver createLocalDriver(String browser) {
    WebDriver driver = null;
    switch (browser.toLowerCase()) {
      case "chrome":
        driver = getChromeDriver();
        break;
      case "firefox":
        driver = getFirefoxDriver();
        break;
      default:
        throw new IllegalArgumentException("Unsupported browser: " + browser);
    }
    return driver;
  }

  private static WebDriver getChromeDriver() {
    WebDriverManager.chromedriver().setup();
    return new ChromeDriver();
  }

  private static WebDriver getFirefoxDriver() {
    WebDriverManager.firefoxdriver().setup();
    return new FirefoxDriver();
  }
}
