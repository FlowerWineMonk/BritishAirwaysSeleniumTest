package vention.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.MutableCapabilities;
import java.net.URL;

public class DriverFactory {
  public static WebDriver createInstance() {
    String browserName = System.getProperty("browser", "chrome").toLowerCase();
    String hubHost = System.getProperty("hubHost", System.getenv("HUB_HOST"));

    return switch (browserName) {
      case "chrome" -> getLocalChromeDriver();
      case "firefox" -> getLocalFirefoxDriver();
      case "remote-chrome" -> getRemoteDriver(getChromeOptions(), hubHost);
      case "remote-firefox" -> getRemoteDriver(getFirefoxOptions(), hubHost);
      default -> throw new IllegalArgumentException("Unsupported browser: " + browserName);
    };
  }

  private static WebDriver getLocalChromeDriver() {
    return new ChromeDriver(getChromeOptions());
  }

  private static WebDriver getLocalFirefoxDriver() {
    return new FirefoxDriver(getFirefoxOptions());
  }

  private static ChromeOptions getChromeOptions() {
    ChromeOptions options = new ChromeOptions();

    if (isCI()) {
      options.addArguments("--headless=new");
      options.addArguments("--no-sandbox");
      options.addArguments("--disable-dev-shm-usage");
      options.addArguments("--disable-gpu");
      options.addArguments("--window-size=1920,1080");
    } else {
      options.addArguments("--start-maximized");
    }

    return options;
  }

  private static FirefoxOptions getFirefoxOptions() {
    FirefoxOptions options = new FirefoxOptions();
    if (isCI()) {
      options.addArguments("--headless");
      options.addArguments("--width=1920");
      options.addArguments("--height=1080");
    } else {
      options.addArguments("--width=1920");
      options.addArguments("--height=1080");
    }
    return options;
  }

  private static boolean isCI() {
    return "true"
        .equals(System.getProperty("ci")) || System.getenv("CI") != null || System.getenv("JENKINS_URL") != null;
  }

  private static WebDriver getRemoteDriver(MutableCapabilities options, String hubHost) {
    if (hubHost == null || hubHost.isEmpty()) {
      throw new RuntimeException("hubHost is not set! Pass -DhubHost=selenium-hub");
    }

    String remoteUrl = "http://" + hubHost + ":4444";

    try {
      return new RemoteWebDriver(new URL(remoteUrl), options);
    } catch (Exception e) {
      throw new RuntimeException("Failed to create RemoteWebDriver with URL: " + remoteUrl, e);
    }
  }
}
