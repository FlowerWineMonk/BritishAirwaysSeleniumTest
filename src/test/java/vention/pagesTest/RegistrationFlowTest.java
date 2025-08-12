package vention.pagesTest;

import vention.steps.RegistrationSteps;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.qameta.allure.*;;

@Epic("User Registration")
@Feature("User registration and profile creation")
public class RegistrationFlowTest extends BaseTest {
  private final RegistrationSteps registrationSteps = new RegistrationSteps();

  @Test
  @Story("New user registers and completes profile setup")
  @Severity(SeverityLevel.CRITICAL)
  @Feature("User registration and profile creation")
  @Description("This test verifies the full registration process for a new user, including profile creation. " +
      "It ensures the system accepts the provided details, processes the registration, " +
      "and redirects the user to the home page upon successful account creation.")
  public void testCompleteUserRegistrationFlowWithProfileCreation() {
    registrationSteps.registerNewUserFlow(newUser, TITLE_VALUE, COUNTRY_CODE_VALUE);

    Assert.assertTrue(registrationSteps.isHomePageVisibleAfterRegistration(),
        "User should be redirected to the home page after profile creation");
  }
}
