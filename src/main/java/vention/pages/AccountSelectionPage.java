package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSelectionPage extends AbstractPage {
  @FindBy(id="remove-family-friend")
  private WebElement continueBtn;

  public AccountSelectionPage() {
    super();
  }

  public void clickContinueWithoutTheBritishAirwaysClubBtn() {
    waitForVisibilityAndClick(continueBtn);
  }
}
