package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
  @FindBy(id = "username")
  private WebElement emailInput;

  @FindBy(id = "password")
  private WebElement passwordInput;

  @FindBy(xpath = "//button[@name='action']")
  private WebElement nextButton;

  public LoginPage() {
    super();
  }

  public void enterLoginCredentials(String email, String password) {
    waitForVisibilityAndSendKeys(emailInput, email);
    waitForVisibilityAndSendKeys(passwordInput, password);
  }

  public void clickNextButton() {
    waitForClickableAndClick(nextButton);
  }

  public boolean isEmailInputDisplayed() {
     return emailInput.isDisplayed();
  }

  public boolean isPasswordInputDisplayed() {
    return passwordInput.isDisplayed();
  }
 
  public boolean isNextButtonDisplayed() {
    return nextButton.isDisplayed();
  }
}
