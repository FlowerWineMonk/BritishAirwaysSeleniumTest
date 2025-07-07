package vention.pages;

import vention.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vention.entity.User;

public class LoginPage extends BasePage {
  private static final String RELATIVE_PATH = "/login";

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
    enterEmailAndPassword(emailInput, passwordInput, user);   
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
