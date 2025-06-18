package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageCredentials extends AbstractPage {
  @FindBy(id = "username")
  private WebElement emailField;

  @FindBy(id = "password")
  private WebElement passwordField;

  @FindBy(xpath = "//div[@id='checkbox']")
  private WebElement captchaField;

  @FindBy(xpath = "//button[@name='action']")
  private WebElement nextButton;

  public LoginPageCredentials() {
    super();
    PageFactory.initElements(driver, this);
  }

  public void SendKeys(String email, String password) {
    waitForVisibilityAndSendKeys(emailField, email);
    waitForVisibilityAndSendKeys(passwordField, password);
  }

  public void CaptchaFieldClick() {
    waitForVisibilityAndClick(captchaField);
  }

  public void NextButtonClick() {
    waitForVisibilityAndClick(nextButton);
  }
}
