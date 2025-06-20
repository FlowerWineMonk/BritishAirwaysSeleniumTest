package vention.pagesTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;

import vention.configLoader.ConfigLoader;
import vention.driver.DriverFactory;
import vention.driver.DriverManager;
import vention.pages.CookiePopupPage;
import vention.pages.PreLoginPage;
import vention.pages.LoginPage;

public class BaseTest {
  WebDriver driver;
  CookiePopupPage cookiePopupPage;
  PreLoginPage preLoginPage;
  LoginPage loginPage;

  @BeforeClass
  public void beforeClass() {
    String browser = ConfigLoader.get("browser");
    DriverManager.setDriver(DriverFactory.createLocalDriver(browser));
  }

  @BeforeMethod
  public void beforeMethod() {
    String url = ConfigLoader.get("pre-login-url");
    DriverManager.getDriver().get(url);

    cookiePopupPage = new CookiePopupPage();
    cookiePopupPage.clickRejectAllBtn();

    preLoginPage = new PreLoginPage();
    preLoginPage.clickLoginBtn();
    loginPage = new LoginPage();
  }
}
