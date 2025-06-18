package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
  private static final String LOGIN_BUTTON = "//button[@data-testid='login-button']";
  private static final Strign REGISTER_BUTTON = "//button[@data-testid='register-button']";

  @FindBy(xpath = LOGIN_BUTTON)
  private WebElement LoginBtn;

  @FindBy(xpath = REGISTER_BUTTON)
  private WebElement RegisterBtn;

  public LoginPage() {
    super();
    PageFactory.initElements(driver, this);
  }

  public void LoginBtnClick() {
    waitForVisibilityAndClick(LoginBtn);
  }

  public void RegisterBtnClick() {
    waitForVisibilityAndClick(RegisterBtn);
  }
}
