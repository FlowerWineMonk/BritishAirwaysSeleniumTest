package subMain.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {
  private static final String LOGIN_BUTTON = "//button[@id='log-button']"; 

  @FindBy(xpath = LOGIN_BUTTON)
  private WebElement LoginBtn;

  public HomePage() {
    super();
    PageFactory.initElements(driver, this);
  }

  public void LoginBtnClick() {
    waitForVisibilityAndClick(LoginBtn);
  }
}
