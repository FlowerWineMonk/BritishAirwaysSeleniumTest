package vention.pages;

import vention.customWebElement.WebElementImp;
import org.openqa.selenium.support.FindBy;

public class AccountSelectionPage extends BasePage {
  private static final String RELATIVE_PATH = "/account-selection";

  @FindBy(id = "remove-family-friend")
  private WebElementImp continueButton;

  @Override
  public String getRelativePath() {
    return RELATIVE_PATH;
  }

  public AccountSelectionPage() {
    super();
  }

  public void clickContinueButton() {
    continueButton.click(15);
  }

  public boolean isContinueButtonDisplayed() {
    return continueButton.isDisplayed();
  }
}
