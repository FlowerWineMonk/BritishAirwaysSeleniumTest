package vention.pages;

import vention.customWebElement.CustomWebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

public class AccountSelectionPage extends BasePage {
  private static final String RELATIVE_PATH = "/account-selection";

  @FindBy(id = "remove-family-friend")
  private CustomWebElement continueButton;

  @Override
  public String getRelativePath() {
    return RELATIVE_PATH;
  }

  public AccountSelectionPage() {
    super();
  }

  @Step("Click on continue button in account-selection page")
  public void clickContinueButton() {
    continueButton.click(30);
  }

  public boolean isContinueButtonDisplayed() {
    return continueButton.isDisplayed();
  }
}
