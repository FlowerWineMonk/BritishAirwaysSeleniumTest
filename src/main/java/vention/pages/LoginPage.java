package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
  @FindBy(xpath = "//button[@data-testid='login-button']")
  private WebElement LoginBtn;

  @FindBy(xpath = "//button[@data-testid='register-button']")
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
