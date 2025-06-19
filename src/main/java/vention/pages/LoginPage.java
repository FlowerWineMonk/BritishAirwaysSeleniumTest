package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
  @FindBy(id = "username")
  private WebElement emailField;

  @FindBy(id = "password")
  private WebElement passwordField;

  @FindBy(xpath = "//div[@id='checkbox']")
  private WebElement captchaField;

  @FindBy(xpath = "//button[@name='action']")
  private WebElement nextBtn;

  public LoginPage() {
    super();
  }

  public void fillLoginCredentials(String email, String password) {
    waitForVisibilityAndSendKeys(emailField, email);
    waitForVisibilityAndSendKeys(passwordField, password);
  }

  public void clickCaptchaField() {
    waitForVisibilityAndClick(captchaField);
  }

  public void clickNextBtn() {
    waitForVisibilityAndClick(nextBtn);
  }
}
