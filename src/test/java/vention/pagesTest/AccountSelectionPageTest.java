package vention.pagesTest;

import vention.pages.AccountSelectionPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class AccountSelectionPageTest extends BaseTest {
  private AccountSelectionPage accountSelectionPage;

  @Test
  public void clickContinueButtonTest() {
    accountSelectionPage = new AccountSelectionPage();
    Assert.assertTrue(accountSelectionPage.isPageOpened(), "User should be redirected to the account selection page after register page");
    Assert.assertTrue(accountSelectionPage.isContinueButtonDisplayed(), "Continue button should be visible during account selection page");
    accountSelectionPage.clickContinueButton();
  }
}
