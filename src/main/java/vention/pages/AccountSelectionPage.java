package vention.pages;

import vention.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSelectionPage extends BasePage {
  private static final String RELATIVE_PATH = "/account-selection";

  @FindBy(id = "remove-family-friend")
  private WebElement continueButton;

  @Override
  public String getRelativePath() {
    return RELATIVE_PATH;
  }

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
