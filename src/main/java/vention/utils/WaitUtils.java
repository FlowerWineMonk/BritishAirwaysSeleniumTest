package vention.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import vention.customWebElement.CustomWebElement;
import vention.driver.DriverManager;

import java.time.Duration;

public class WaitUtils {
  private static final int DEFAULT_TIME = 10;

  private static WebDriverWait createWait(int timeOut) {
    return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut));
  }

  public static CustomWebElement waitElementToBeClickable(CustomWebElement customElement) {
    return waitElementToBeClickable(customElement, DEFAULT_TIME);
  }

  public static CustomWebElement waitElementToBeVisible(CustomWebElement customElement) {
    return waitElementToBeVisible(customElement, DEFAULT_TIME);
  }

  public static CustomWebElement waitElementToBeClickable(CustomWebElement customElement, int seconds) {
    By locator = customElement.getCurrentLocator();
    createWait(seconds).until(ExpectedConditions.elementToBeClickable(locator));
    return customElement;
  }

  public static CustomWebElement waitElementToBeVisible(CustomWebElement customElement, int seconds) {
    By locator = customElement.getCurrentLocator();
    createWait(seconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
    return customElement;
  }

  public static boolean waitForUrlContains(String partialUrl, int seconds) {
    return createWait(seconds).until(ExpectedConditions.urlContains(partialUrl));
  }

  public static void waitForVisibilityOfElementLocated(String cssSelector, int seconds) {
    By locator = By.cssSelector(cssSelector);
    createWait(seconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public static CustomWebElement waitForElementReload(CustomWebElement customElement, int seconds) {
    By locator = customElement.getCurrentLocator();
    try {
      WebElement oldElement = DriverManager.getDriver().findElement(locator);
      createWait(seconds).until(ExpectedConditions.stalenessOf(oldElement));
      System.out.println("Element went stale within " + seconds + " seconds.");
    } catch (Exception ignored) {
      System.out.println("Element did not go stale within " + seconds + " seconds.");
    }
    createWait(seconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
    return customElement;
  }
}
