package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreLoginPage extends BasePage {
  private static final String PRE_LOGIN_PATH = "/nx/b/account/en/usa/account/pre-login";

  @FindBy(xpath = "//button[@data-testid='login-button']")
  private WebElement loginButton;

  @FindBy(xpath = "//button[@data-testid='register-button']")
  private WebElement registerButton;

  @Override
  public String getRelativePath() {
    return PRE_LOGIN_PATH;
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

  public boolean isLoginButtonDisplayed() {
    return loginButton.isDisplayed();
  }

  public boolean isRegisterButtonDisplayed() {
    return registerButton.isDisplayed();
  }
}
