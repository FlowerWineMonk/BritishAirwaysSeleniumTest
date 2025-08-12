package vention.pages;

import vention.customWebElement.WebElementImp;
import org.openqa.selenium.support.FindBy;
import vention.entity.User;
import io.qameta.allure.Step;

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

  @Step("Enter login credentials: email and password")
  public void enterLoginCredentials(User user) {
    enterEmailAndPassword(emailInput, passwordInput, user);
  }

  @Step("Click next button")
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
