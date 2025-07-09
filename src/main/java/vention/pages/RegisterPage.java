package vention.pages;

import vention.WebElementImp.CustomElement;
import org.openqa.selenium.support.FindBy;
import vention.entity.User;

public class RegisterPage extends BasePage {
  private static final String RELATIVE_PATH = "/email-validation";

  @FindBy(id = "emailInput--inputtext--input")
  private CustomElement emailInput;

  @FindBy(id = "passwordInput--inputtext--input")
  private CustomElement passwordInput;

  @FindBy(xpath = "//button[@data-testid='validation-submit-button']")
  private CustomElement continueButton;

  @Override
  public String getRelativePath() {
    return RELATIVE_PATH;
  }

  public RegisterPage() {
    super();
  }

  public void enterRegisterCredentials(User user) {
    enterEmailAndPassword(emailInput, passwordInput, user);
  }

  public void clickContinueButton() {
    continueButton.click();
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
