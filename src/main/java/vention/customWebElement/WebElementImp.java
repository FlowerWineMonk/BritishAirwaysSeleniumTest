package vention.customWebElement;

import vention.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import java.time.Duration;

public class WebElementImp implements BaseElement {
  private final WebElement element;
  private final By locator;
  private static final int DEFAULT_TIME = 20;

  public WebElementImp(WebElement element) {
    this.element = element;
    this.locator = null;
  }

  public WebElementImp(By locator) {
    this.element = null;
    this.locator = locator;
  }

  private WebElement waitElementToBeClickable(WebElement element) {
    return waitElementToBeClickable(element, DEFAULT_TIME);
  }

  private WebElement waitElementToBeVisible(WebElement element) {
    return waitElementToBeVisible(element, DEFAULT_TIME);
  }

  private WebElement waitElementToBeClickable(WebElement element, int seconds) {
    return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds))
        .until(ExpectedConditions.elementToBeClickable(element));
  }

  private WebElement waitElementToBeVisible(WebElement element, int seconds) {
    return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds))
        .until(ExpectedConditions.visibilityOf(element));
  }

  public static void clickByLocator(By locator, int seconds) {
    new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds))
        .until(ExpectedConditions.elementToBeClickable(locator)).click();
  }

  @Override
  public void click() {
    waitElementToBeClickable(element).click();
  }

  public void sendKeys(String text) {
    waitElementToBeVisible(element).sendKeys(text);
  }

  public void click(int seconds) {
    waitElementToBeClickable(element, seconds).click();
  }

  public void sendKeys(String text, int seconds) {
    waitElementToBeVisible(element, seconds).sendKeys(text);
  }

  @Override
  public boolean isDisplayed() {
    waitElementToBeVisible(element);
    return element.isDisplayed();
  }

  @Override
  public String getText() {
    return element.getText();
  }
}
