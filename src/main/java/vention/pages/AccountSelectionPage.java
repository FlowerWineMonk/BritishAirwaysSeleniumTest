package vention.pages;

import vention.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSelectionPage extends BasePage {
  private static final String ACCOUNT_SELECTION_URL = "/account-selection";

  @FindBy(id = "remove-family-friend")
  private WebElement continueButton;

  public AccountSelectionPage() {
    super();
  }

  public boolean isOnAccountSelectionPage() {
    String currentUrl = DriverManager.getDriver().getCurrentUrl();
    return currentUrl.contains(ACCOUNT_SELECTION_URL);
  }

  public void clickContinueButton() {
    waitForClickableAndClick(continueButton, 15);
  }

  public boolean isContinueButtonDisplayed() {
    return continueButton.isDisplayed();
  }
}
