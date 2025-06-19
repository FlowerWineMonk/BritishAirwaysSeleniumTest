package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.seleninum.By;

public class CreateProfilePage extends BasePage {
  @FindBy(id = "title")
  private WebElement selectTitle;

  @FindBy(id = "firstname--inputtext--input")
  private WebElement firstNameField;

  @FindBy(id = "lastname--inputtext--input")
  private WebElement lastNameField;

  @FindBy(id = "countrycode")
  private WebElement selectPhoneNumber;

  @FindBy(id = "phoneNumber--inputtext--input")
  private WebElement phoneNumberField;

  @FindBy(xpath = "//button[@data-testid='register-submit-button']")
  private WebElement registerBtn;

  public CreateProfilePage() {
    super();
  }

  public void chooseTitle(String titleValue) {
    waitForVisibilityAndClick(selectTitle) {
    driver.findElement(By.xpath("//option[@value='" + titleValue + "']")).click();
  }

  public void fillNameCredentials(String firstName, String lastName) {
    waitForVisibilityAndSendKeys(firstNameField, firstName);
    waitForVisibilityAndSendKeys(lastNameField, lastName);
  }

  public void chooseCountryCode(String code) {
    waitForVisibilityAndClick(selectPhoneNumber);
    driver.findElement(By.xpath("//option[@value='" + code + "']")).click();
  }

  public void fillPhoneNumber(String phoneNumber) {
    waitForVisibilityAndSendKeys(phoneNumberField, phoneNumber);
  }

  public void clickRegisterBtn() {
    waitForVisibilityAndClick(registerBtn);
  }
}
