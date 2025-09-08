package vention.pages;

import vention.customWebElement.CustomWebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

public class PreLoginPage extends BasePage {
  private static final String RELATIVE_PATH = "/nx/b/account/en/usa/account/pre-login";

  @FindBy(xpath = "//button[@data-testid='login-button']")
  private CustomWebElement loginButton;

  @FindBy(xpath = "//button[@data-testid='register-button']")
  private CustomWebElement registerButton;

  @Override
  public String getRelativePath() {
    return RELATIVE_PATH;
  }

  public PreLoginPage() {
    super();
  }

  @Step("Click login button")
  public void clickLoginButton() {
    loginButton.click(5);
  }

  @Step("Click register button")
  public void clickRegisterButton() {
    registerButton.click(5);
  }

  public boolean isLoginButtonDisplayed() {
    return loginButton.isDisplayed();
  }

  public boolean isRegisterButtonDisplayed() {
    return registerButton.isDisplayed();
  }
}
