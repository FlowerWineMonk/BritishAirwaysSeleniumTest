package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
  @FindBy(id = "emailInput--inputtext--input")
  private WebElement emailField;

  @FindBy(id = "passwordInput--inputtext--input")
  private WebElement passwordField;

  @FindBy(xpath = "//button[@data-testid='validation-submit-button']")
  private WebElement continueBtn;

  public RegisterPage() {
    super();
  }

  public void fillRegisterCredentials(String email, String password) {
    waitForVisibilityAndSendKeys(emailField, email);
    waitForVisibilityAndSendKeys(passwordField, password);
  }

  public void clickContinueBtn() {
    waitForVisibilityAndClick(continueBtn);
  }
}
