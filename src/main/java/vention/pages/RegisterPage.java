package vention.pages;

import vention.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vention.entity.User;

public class RegisterPage extends BasePage {
  private static final String RELATIVE_PATH = "/email-validation";

  @FindBy(id = "emailInput--inputtext--input")
  private WebElement emailInput;

  @FindBy(id = "passwordInput--inputtext--input")
  private WebElement passwordInput;

  @FindBy(xpath = "//button[@data-testid='validation-submit-button']")
  private WebElement continueButton;

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
