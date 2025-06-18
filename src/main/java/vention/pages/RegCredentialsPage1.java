package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegCredentialsPage1 extends AbstractPage {
  @FindBy(id="remove-family-friend")
  private WebElement continueButton;

  public RegCredentialsPage1() {
    super();
    PageFactory.initElements(driver, this);
  }

  public void pressContinueButton() {
    waitForVisibilityAndClick(continueButton);
  }
}
