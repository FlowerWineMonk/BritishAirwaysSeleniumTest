package vention.pages;

import vention.WebElementImp.CustomElement;
import org.openqa.selenium.support.FindBy;

public class CookiePopup extends BasePage {
  @FindBy(id = "ensCloseBanner")
  private CustomElement rejectAllButton;

  public CookiePopup() {
    super();
  }
 
  public void clickRejectAllButton() {
    rejectAllButton.click();
  }

  public boolean isRejectAllButtonDisplayed() {
    return rejectAllButton.isDisplayed();
  }
}
