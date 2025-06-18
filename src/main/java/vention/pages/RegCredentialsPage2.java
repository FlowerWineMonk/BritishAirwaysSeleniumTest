package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.seleninum.By;

public class RegCredentialsPage2 extends AbstractPage {
  @FindBy(id = "title")
  private WebElement selectTitle;

  @FindBy(id = "firstname--inputtext--input")
  private WebElement inputFirstName;

  @FindBy(id = "lastname--inputtext--input")
  private WebElement inputLastName;

  @FindBy(id = "countrycode")
  private WebElement selectPhoneNumber;

  @FindBy(id="phoneNumber--inputtext--input")
  private WebElement inputPhoneNumber;

  @FindBy(xpath = "//button[@data-testid='register-submit-button']")
  private WebElement registerButton;

  public RegCredentialsPage2() {
    super();
    PageFactory.initElements(driver, this);
  }

  public void chooseTitle() {
    waitForVisibilityAndClick(selectTitle);
    driver.findElement(By.xpath("//option[@value='" + titleValue + "']")).click();
  }

  public void inputCredentials(String firstName, String lastName) {
    waitForVisibilityAndSendKeys(inputFirstName, firstName);
    waitForVisibilityAndSendKeys(inputLastName, lastName);
  }

  public void chooseCountryCode() {
    waitForVisibilityAndClick(selectPhoneNumber);
    driver.findElement(By.xpath("//option[@value='" + code + "']")).click();
  }

  public void inputPhoneNumber(String phoneNumber) {
    waitForVisibilityAndSendKeys(inputPhoneNumber, phoneNumber);
  }

  public void clickRegisterButton() {
    waitForVisibilityAndClick(registerButton);
  }
}
