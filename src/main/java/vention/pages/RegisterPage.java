package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vention.entity.User;

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

  public void enterRegisterCredentials(User user) {
    waitForVisibilityAndSendKeys(emailInput, user.getEmail());
    waitForVisibilityAndSendKeys(passwordInput, user.getPassword());
  }

  public void clickContinueButton() {
    waitForClickableAndClick(continueButton);
  }

  public boolean isEmailInputDisplayed() {
    return emailInput.isDisplayed();
  }

  public boolean isPasswordInputDisplayed() {
    return passwordInput.isDisplayed();
  }

  public boolean isContinueButtonDisplayed() {
    return continueButton.isDisplayed();
  }
}
