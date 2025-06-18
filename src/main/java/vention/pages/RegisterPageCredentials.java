package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageCredentials extends AbstractPage {
  private static final String EMAIL_INPUT_FIELD = "//input[@data-testid='validation-email-input']";
  private static final String PASSWORD_INPUT_FIELD= "//input[@data-testid='validation-password-input']";
  private static final String CONTINUE_BUTTON = "//button[@data-testid='validation-submit-button']";

  @FindBy(xpath = EMAIL_INPUT_FIELD)
  private WebElement emailField;

  @FindBy(xpath = PASSWORD_INPUT_FIELD)
  private WebElement passwordField;

  @FindBy(xpath = CONTINUE_BUTTON)
  private WebElement continueButton;

  public RegisterPageCredentials() {
    super();
    PageFactory.initElements(driver, this);
  }

  public void EmailFieldSendKeys(String email) {
    waitForVisibilityAndSendKeys(emailField, email);
  }

  public void PasswordFieldSendKeys(String password) {
    waitForVisibilityAndSendKeys(passwordField, password);
  }

  public void ContinueButtonClick() {
    waitForVisibilityAndClick(continueButton);
  }
}
