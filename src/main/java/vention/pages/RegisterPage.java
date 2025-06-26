package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
  @FindBy(id = "emailInput--inputtext--input")
  private WebElement emailInput;

  @FindBy(id = "passwordInput--inputtext--input")
  private WebElement passwordInput;

  @FindBy(xpath = "//button[@data-testid='validation-submit-button']")
  private WebElement continueButton;

  public RegisterPage() {
    super();
  }

  public void enterRegisterCredentials(String email, String password) {
    waitForVisibilityAndSendKeys(emailInput, email);
    waitForVisibilityAndSendKeys(passwordInput, password);
  }

  public void clickContinueButton() {
    waitForClickableAndClick(continueButton);
  }
}
