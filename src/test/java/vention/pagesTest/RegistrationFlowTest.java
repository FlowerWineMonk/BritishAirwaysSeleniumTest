package vention.pagesTest;

import vention.pagesTest.PreLoginPageTest;
import vention.pagesTest.RegisterPageTest;
import vention.pagesTest.AccountSelectionPageTest;
import vention.pagesTest.CreateProfilePageTest;
import vention.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class RegistrationFlowTest extends BaseTest {
  private PreLoginPageTest preLoginPageTest;
  private RegisterPageTest registerPageTest;
  private AccountSelectionPageTest accountSelectionPageTest;
  private CreateProfilePageTest createProfilePageTest;
  private HomePage homePage;

  @Test
  public void testCompleteUserRegistrationFlowWithProfileCreation() {
    preLoginPageTest = new PreLoginPageTest();
    preLoginPageTest.clickRegisterButtonTest();

    registerPageTest = new RegisterPageTest();
    registerPageTest.enterRegisterCredentialsTest();

    accountSelectionPageTest = new AccountSelectionPageTest();
    accountSelectionPageTest.clickContinueButtonTest();

    createProfilePageTest = new CreateProfilePageTest();
    createProfilePageTest.enterProfileCredentialsTest();

    homePage = new HomePage();
    Assert.assertTrue(homePage.isPageOpened(), "User should be redirected to the home page after profile creation");
  }
}
