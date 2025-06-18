package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {
  @FindBy(id = "log-button")
  private WebElement LoginBtn;

  public HomePage() {
    super();
    PageFactory.initElements(driver, this);
  }

  public void LoginBtnClick() {
    waitForVisibilityAndClick(LoginBtn);
  }
}
