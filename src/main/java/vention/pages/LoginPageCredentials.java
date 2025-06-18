package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageCredentials extends AbstractPage {
  private static final String EMAIL_INPUT_FIELD = "//input[@id='username']";
  private static final String PASSWORD_INPUT_FIELD = "//input[@id='password']";
  private static final String CAPTCHA_CLICK = "//div[@id='anchor-tc']";
  private static final String CONTINUE_BUTTON = "//button[@name='action']";

  @FindBy(xpath = EMAIL_INPUT_FIELD)
  private WebElement emailField;

  @FindBy(xpath = PASSWORD_INPUT_FIELD)
  private WebElement passwordField;

  @FindBy(xpath = CAPTCHA_CLICK)
  private WebElement captchaField;

  @FindBy(xpath = CONTINUE_BUTTON)
  private WebElement nextButton;

  public LoginPageCredentials() {
    super();
    PageFactory.initElements(driver, this);
  }

  public void EmailFieldSendKeys(String email) {
    waitForVisibilityAndSendKeys(emailField, email);
  }

  public void PasswordFieldSendKeys(String password) {
    waitForVisibilityAndSendKeys(passwordField, password);
  }

  public void CaptchaFieldClick() {
    waitForVisibilityAndClick(captchaField);
  }

  public void NextButtonClick() {
    waitForVisibilityAndClick(nextButton);
  }
}
