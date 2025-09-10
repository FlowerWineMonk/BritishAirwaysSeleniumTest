package vention.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import vention.driver.DriverManager;

public class AllureTestListener implements ITestListener {

  @Override
  public void onTestFailure(ITestResult result) {
    WebDriver driver = DriverManager.getDriver();
    if (driver != null) {
      saveScreenshot(driver);
    }
  }

  @Attachment(value = "Failure Screenshot", type = "image/png")
  public byte[] saveScreenshot(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }
}
