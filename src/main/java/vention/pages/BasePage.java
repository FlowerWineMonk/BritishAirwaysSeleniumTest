package vention.pages;

import vention.configLoader.ConfigLoader;
import vention.driver.DriverManager;
import vention.entity.User;
import vention.customWebElement.WebElementImp;
import vention.customWebElement.CustomFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
  public BasePage() {
    PageFactory.initElements(new CustomFieldDecorator(DriverManager.getDriver()), this);
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

  protected void enterEmailAndPassword(WebElementImp emailInput, WebElementImp passwordInput, User user) {
    emailInput.sendKeys(user.getEmail());
    passwordInput.sendKeys(user.getPassword());
  }
}
