package vention.pages;

import vention.configLoader.ConfigLoader;
import vention.driver.DriverManager;
import vention.entity.User;
import vention.customWebElement.CustomWebElement;
import vention.customWebElement.CustomFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;

public abstract class BasePage {
  public BasePage() {
    PageFactory.initElements(new CustomFieldDecorator(DriverManager.getDriver()), this);
  }

  public String getRelativePath() {
    return "";
  }

  @Step("Open page: {pageName}")
  public void openPage(String pageName) {
    DriverManager.getDriver().get(getBaseUrl() + getRelativePath());
  }

  public void openPage() {
    openPage(this.getClass().getSimpleName());
  }

  public String getBaseUrl() {
    return ConfigLoader.get("BASE_URL");
  }

  public boolean isPageOpened() {
    String currentUrl = DriverManager.getDriver().getCurrentUrl();
    return currentUrl.contains(getRelativePath());
  }

  protected void enterEmailAndPassword(CustomWebElement emailInput, CustomWebElement passwordInput, User user) {
    emailInput.sendKeys(user.getEmail());
    passwordInput.sendKeys(user.getPassword());
  }
}
