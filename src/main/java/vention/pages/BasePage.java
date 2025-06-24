package vention.pages;

import vention.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import java.time.Duration;

public abstract class BasePage {
  WebDriver driver;
  WebDriverWait wait;

  public BasePage() {
    this.driver = DriverManager.getDriver();
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(driver, this);
  }

  protected void waitForVisibility(WebElement element) {
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  protected void waitForClickable(WebElement element) {
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  protected void waitForVisibilityAndClick(WebElement element) {
    waitForClickable(element);
    element.click();
  }

  protected void waitForVisibilityAndClickByLocator(By locator) {
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    element.click();
  }

  protected void waitForVisibilityAndSendKeys(WebElement element, String text) {
    waitForVisibility(element);
    element.sendKeys(text);
  }
}
