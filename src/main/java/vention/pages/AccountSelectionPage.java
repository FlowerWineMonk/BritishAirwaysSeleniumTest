package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSelectionPage extends BasePage {
  @FindBy(id = "remove-family-friend")
  private WebElement continueButton;

  public AccountSelectionPage() {
    super();
  }

  public void clickContinueButton() {
    waitForClickableAndClick(continueButton, 15);
  }

  public boolean isContinueButtonDisplayed() {
    return continueButton.isDisplayed();
  }
}
