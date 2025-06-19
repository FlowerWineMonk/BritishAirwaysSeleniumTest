package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PreLoginPage extends BasePage {
  @FindBy(xpath = "//button[@data-testid='login-button']")
  private WebElement loginBtn;

  @FindBy(xpath = "//button[@data-testid='register-button']")
  private WebElement registerBtn;

  public PreLoginPage() {
    super();
  }

  public void clickLoginBtn() {
    waitForVisibilityAndClick(loginBtn);
  }

  public void clickRegisterBtn() {
    waitForVisibilityAndClick(registerBtn);
  }
}
