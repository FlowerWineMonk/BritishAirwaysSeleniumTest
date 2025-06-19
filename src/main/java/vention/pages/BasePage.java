package vention.pages;

import vention.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {
  WebDriver driver;
  WebDriverWait wait;

  public AbstractPage() {
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

  protected void waitForVisibilityAndSendKeys(WebElement element, String text) {
    waitForVisibility(element);
    element.sendKeys(text);
  }
}
