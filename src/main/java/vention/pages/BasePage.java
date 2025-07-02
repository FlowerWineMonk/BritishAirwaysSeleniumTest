package vention.pages;

import vention.configLoader.ConfigLoader;
import vention.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import java.time.Duration;

public abstract class BasePage {
  private static final int DEFAULT_TIME = 10;

  public BasePage() {
    PageFactory.initElements(DriverManager.getDriver(), this);
  }

  public String getRelativePath() {
    return "";
  }

  public void openPage() {
    DriverManager.getDriver().get(getBaseUrl() + getRelativePath());
  }

  public String getBaseUrl() {
    return ConfigLoader.get("BASE_URL");
  }

  public boolean isPageOpened() {
    String currentUrl = DriverManager.getDriver().getCurrentUrl();
    return currentUrl.contains(getRelativePath());
  }

  protected WebDriverWait getWait(int seconds) {
    return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds));
  }

  protected void waitForVisibility(WebElement element) {
    waitForVisibility(element, DEFAULT_TIME);
  }

  protected void waitForVisibility(WebElement element, int seconds) {
    getWait(seconds).until(ExpectedConditions.visibilityOf(element));
  }

  protected void waitForClickable(WebElement element) {
    waitForClickable(element, DEFAULT_TIME);
  }

  protected void waitForClickable(WebElement element, int seconds) {
    getWait(seconds).until(ExpectedConditions.elementToBeClickable(element));
  }

  protected void waitForClickableAndClick(WebElement element) {
    waitForClickableAndClick(element, DEFAULT_TIME);
  }

  protected void waitForClickableAndClick(WebElement element, int seconds) {
    waitForClickable(element, seconds);
    element.click();
  }

  protected void waitForVisibilityAndClickByLocator(By locator, int seconds) {
    getWait(seconds).until(ExpectedConditions.elementToBeClickable(locator)).click();
  }

  protected void waitForVisibilityAndSendKeys(WebElement element, String text) {
    waitForVisibilityAndSendKeys(element, text, DEFAULT_TIME);
  }

  protected void waitForVisibilityAndSendKeys(WebElement element, String text, int seconds) {
    waitForVisibility(element, seconds);
    element.sendKeys(text);
  }
}
