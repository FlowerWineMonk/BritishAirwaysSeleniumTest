package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
  @FindBy(id = "username")
  private WebElement emailField;

  @FindBy(id = "password")
  private WebElement passwordField;

  @FindBy(xpath = "//button[@name='action']")
  private WebElement nextBtn;

  public LoginPage() {
    super();
  }

  public void fillLoginCredentials(String email, String password) {
    waitForVisibilityAndSendKeys(emailField, email);
    waitForVisibilityAndSendKeys(passwordField, password);
  }

  public void clickNextBtn() {
    waitForVisibilityAndClick(nextBtn);
  }

  public boolean isEmailFieldDisplayed() {
     return emailField.isDisplayed();
  }

  public boolean isPasswordFieldDisplayed() {
    return passwordField.isDisplayed();
  }
 
  public boolean isNextBtnDisplayed() {
    return nextBtn.isDisplayed();
  }
}
