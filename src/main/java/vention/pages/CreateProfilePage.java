package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

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

  public void selectTitle(String titleValue) {
    waitForVisibilityAndClick(selectTitle);
    waitForVisibilityAndClickByLocator(By.xpath("//option[@value='" + titleValue + "']"));
  }

  public void fillNameCredentials(String firstName, String lastName) {
    waitForVisibilityAndSendKeys(firstNameField, firstName);
    waitForVisibilityAndSendKeys(lastNameField, lastName);
  }

  public void selectCountryCode(String code) {
    waitForVisibilityAndClick(selectPhoneNumber);
    waitForVisibilityAndClickByLocator(By.xpath("//option[@value='" + code + "']"));
  }

  public void fillPhoneNumber(String phoneNumber) {
    waitForVisibilityAndSendKeys(phoneNumberField, phoneNumber);
  }

  public void clickRegisterBtn() {
    waitForVisibilityAndClick(registerBtn);
  }

  public boolean isSelectTitleDisplayed() {
    return selectTitle.isDisplayed();
  }

  public boolean isFirstNameFieldDisplayed() {
    return firstNameField.isDisplayed();
  }

  public boolean isLastNameFieldDisplayed() {
    return lastNameField.isDisplayed();
  }

  public boolean isSelectPhoneNumberDisplayed() {
    return selectPhoneNumber.isDisplayed();
  }

  public boolean isPhoneNumberFieldDisplayed() {
    return phoneNumberField.isDisplayed();
  }

  public boolean isRegisterBtnDisplayed() {
    return registerBtn.isDisplayed();
  }
}
