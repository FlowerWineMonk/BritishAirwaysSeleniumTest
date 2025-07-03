package vention.pagesTest;

import vention.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
  private HomePage homePage;

  @Test
  public void openHomePageTest() {
    homePage = new HomePage();
    homePage.openPage();
    Assert.assertTrue(homePage.isPageOpened(), "Home page should open successfully");
  }
}
