package vention.customWebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import vention.utils.WaitUtils;
import vention.driver.DriverManager;

public class CustomWebElement implements BaseElement {
  private final DynamicLocator dynamicLocator;
  private String[] currentArgs;
  private final int TIMEOUT = 10;

  public CustomWebElement(DynamicLocator dynamicLocator) {
    this.dynamicLocator = dynamicLocator;
    this.currentArgs = new String[0];
  }

  public CustomWebElement(WebElement wrappedElement) {
    this.dynamicLocator = null;
    this.currentArgs = new String[0];
  }

  public CustomWebElement withArgs(String... args) {
    this.currentArgs = args.clone();
    return this;
  }

  public WebElement getWrappedElement() {
    if (dynamicLocator != null) {
      By locator = dynamicLocator.createLocator(currentArgs);
      return DriverManager.getDriver().findElement(locator);
    }
    throw new IllegalStateException("No dynamic locator available");
  }

  public By getCurrentLocator() {
    if (dynamicLocator != null) {
      return dynamicLocator.createLocator(currentArgs);
    }
    throw new IllegalStateException("No dynamic locator available");
  }

  public Select asSelect() {
    return new Select(getWrappedElement());
  }

  public void waitForReloadAndClick() {
    WaitUtils.waitForElementReload(this, TIMEOUT).click();
  }

  public void waitForReloadAndSelectByValue(String value) {
    WaitUtils.waitForElementReload(this, TIMEOUT).asSelect().selectByValue(value);
  }

  public void waitForVisibilityAndSelectByValue(String value, String cssSelector) {
    WaitUtils.waitForVisibilityOfElementLocated(cssSelector, TIMEOUT);
    this.asSelect().selectByValue(value);
  }

  public void clearAndTypeWithReload(String text) {
    CustomWebElement reloadedElement = WaitUtils.waitForElementReload(this, TIMEOUT);
    reloadedElement.getWrappedElement().clear();
    reloadedElement.sendKeys(text);
  }

  public void waitForReloadAndClickOption(CustomWebElement dynamicOption, String optionValue) {
    WaitUtils.waitForElementReload(dynamicOption.withArgs(optionValue), TIMEOUT).click();
  }

  @Override
  public void click() {
    WaitUtils.waitElementToBeClickable(this).getWrappedElement().click();
  }

  @Override
  public void sendKeys(String text) {
    WaitUtils.waitElementToBeVisible(this).getWrappedElement().sendKeys(text);
  }

  public void click(int seconds) {
    WaitUtils.waitElementToBeClickable(this, seconds).getWrappedElement().click();
  }

  public void sendKeys(String text, int seconds) {
    WaitUtils.waitElementToBeVisible(this, seconds).getWrappedElement().sendKeys(text);
  }

  @Override
  public boolean isDisplayed() {
    try {
      WaitUtils.waitElementToBeVisible(this);
      return getWrappedElement().isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public String getText() {
    return WaitUtils.waitElementToBeVisible(this).getWrappedElement().getText();
  }
}
