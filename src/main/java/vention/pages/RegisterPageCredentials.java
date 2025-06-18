package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageCredentials extends AbstractPage {
  @FindBy(id = "emailInput--inputtext--input")
  private WebElement emailField;

  @FindBy(id = "passwordInput--inputtext--input")
  private WebElement passwordField;

  @FindBy(xpath = "//button[@data-testid='validation-submit-button']")
  private WebElement continueButton;

  public RegisterPageCredentials() {
    super();
    PageFactory.initElements(driver, this);
  }

  public void SendRegisterCredentials(String email, String password) {
    waitForVisibilityAndSendKeys(emailField, email);
    waitForVisibilityAndSendKeys(passwordField, password);
  }

  public void ContinueButtonClick() {
    waitForVisibilityAndClick(continueButton);
  }
}
