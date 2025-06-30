package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vention.entity.User;

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

  public void enterLoginCredentials(User user) {
    waitForVisibilityAndSendKeys(emailInput, user.getEmail());
    waitForVisibilityAndSendKeys(passwordInput, user.getPassword());
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
