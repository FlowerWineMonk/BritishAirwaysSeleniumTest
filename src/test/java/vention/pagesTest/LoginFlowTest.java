package vention.pagesTest;

import vention.steps.LoginSteps;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.qameta.allure.*;

@Epic("User Authentication")
@Feature("Login functionality")
public class LoginFlowTest extends BaseTest {
  private final LoginSteps loginSteps = new LoginSteps();

  @Test
  @Story("Existing user logs into the platform")
  @Severity(SeverityLevel.BLOCKER)
  @Description("This test verifies that when an existing registered user logs in with valid credentials, " +
      "the system authenticates them and redirects to the home page. " +
      "It ensures the login flow works from entering credentials to confirming the home page is visible.")
  public void testCompleteUserLoginFlow() {
    loginSteps.loginWithExistingUser(existingUser);

    Assert.assertTrue(loginSteps.isHomePageVisibleAfterLogin(),
        "User should be redirected to the home page after login");
  }
}
