package vention.pagesTest;

import vention.pages.HomePage;
import vention.steps.RegistrationSteps;
import org.testng.annotations.Test;
import org.testng.Assert;

public class RegistrationFlowTest extends BaseTest {
  private final RegistrationSteps registrationSteps = new RegistrationSteps();

  @Test
  public void testCompleteUserRegistrationFlowWithProfileCreation() {
    registrationSteps.registerNewUserFlow();

    HomePage homePage = new HomePage();
    Assert.assertTrue(homePage.isPageOpened(), "User should be redirected to the home page after profile creation");
  }
}
