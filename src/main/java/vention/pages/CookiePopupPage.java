package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookiePopupPage extends BasePage {
  @FindBy(xpath = "//button[@id = 'ensCloseBanner']")
  private WebElement rejectAllBtn;

  public CookiePopupPage() {
    super();
  }

  public void clickRejectAllBtn() {
    waitForVisibilityAndClick(rejectAllBtn);
  }
}
