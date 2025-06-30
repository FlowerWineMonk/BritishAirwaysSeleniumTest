package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookiePopup extends BasePage {
  @FindBy(xpath = "//button[@id = 'ensCloseBanner']")
  private WebElement rejectAllButton;

  public CookiePopup() {
    super();
  }
 
  public void clickRejectAllButton() {
    waitForClickableAndClick(rejectAllButton);
  }

  public boolean isRejectAllButtonDisplayed() {
    return rejectAllButton.isDisplayed();
  }
}
