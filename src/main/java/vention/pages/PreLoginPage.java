package vention.pages;

import vention.customWebElement.WebElementImp;
import org.openqa.selenium.support.FindBy;

public class PreLoginPage extends BasePage {
  private static final String RELATIVE_PATH = "/nx/b/account/en/usa/account/pre-login";

  @FindBy(xpath = "//button[@data-testid='login-button']")
  private WebElementImp loginButton;

  @FindBy(xpath = "//button[@data-testid='register-button']")
  private WebElementImp registerButton;

  @Override
  public String getRelativePath() {
    return RELATIVE_PATH;
  }

  public PreLoginPage() {
    super();
  }

  public void clickLoginButton() {
    loginButton.click(15);
  }

  public void clickRegisterButton() {
    registerButton.click(15);
  }

  public boolean isLoginButtonDisplayed() {
    return loginButton.isDisplayed();
  }

  public boolean isRegisterButtonDisplayed() {
    return registerButton.isDisplayed();
  }
}
