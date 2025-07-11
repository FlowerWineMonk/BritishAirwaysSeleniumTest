package vention.pages;

import vention.customWebElement.WebElementImp;
import org.openqa.selenium.support.FindBy;
import vention.entity.User;

public class LoginPage extends BasePage {
  private static final String RELATIVE_PATH = "/login";

  @FindBy(id = "username")
  private WebElementImp emailInput;

  @FindBy(id = "password")
  private WebElementImp passwordInput;

  @FindBy(xpath = "//button[@name='action']")
  private WebElementImp nextButton;

  public LoginPage() {
    super();
  }

  public void enterLoginCredentials(User user) {
    enterEmailAndPassword(emailInput, passwordInput, user);   
  }

  public void clickNextButton() {
    nextButton.click();
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
