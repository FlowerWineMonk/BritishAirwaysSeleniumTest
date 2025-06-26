package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreLoginPage extends BasePage {
  @FindBy(xpath = "//button[@data-testid='login-button']")
  private WebElement loginButton;

  @FindBy(xpath = "//button[@data-testid='register-button']")
  private WebElement registerButton;

  @Override
  public String getRelativePath() {
    return "/nx/b/account/en/usa/account/pre-login";
  }

  public PreLoginPage() {
    super();
  }

  public void clickLoginButton() {
    waitForClickableAndClick(loginButton, 15);
  }

  public void clickRegisterButton() {
    waitForClickableAndClick(registerButton, 15);
  }
}
