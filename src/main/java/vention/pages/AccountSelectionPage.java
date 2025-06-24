package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSelectionPage extends BasePage {
  @FindBy(id="remove-family-friend")
  private WebElement continueBtn;

  public AccountSelectionPage() {
    super();
  }

  public void clickContinueWithoutTheBritishAirwaysClubBtn() {
    waitForVisibilityAndClick(continueBtn);
  }
}
