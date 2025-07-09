package vention.pages;

import vention.WebElementImp.CustomElement;
import org.openqa.selenium.support.FindBy;
import vention.entity.User;

public class LoginPage extends BasePage {
  private static final String RELATIVE_PATH = "/login";

  @FindBy(id = "username")
  private CustomElement emailInput;

  @FindBy(id = "password")
  private CustomElement passwordInput;

  @FindBy(xpath = "//button[@name='action']")
  private CustomElement nextButton;

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
