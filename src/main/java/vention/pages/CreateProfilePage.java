package vention.pages;

import vention.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import vention.entity.User;

public class CreateProfilePage extends BasePage {
  private static final String CREATE_PROFILE_URL = "/register";

  @FindBy(id = "title")
  private WebElement titleDropdown;

  @FindBy(id = "firstname--inputtext--input")
  private WebElement firstNameInput;

  @FindBy(id = "lastname--inputtext--input")
  private WebElement lastNameInput;

  @FindBy(id = "countrycode")
  private WebElement countryCodeDropdown;

  @FindBy(id = "phoneNumber--inputtext--input")
  private WebElement phoneNumberInput;

  @FindBy(xpath = "//button[@data-testid='register-submit-button']")
  private WebElement registerButton;

  public CreateProfilePage() {
    super();
  }

  public boolean isOnCreateProfilePage() {
    String currentUrl = DriverManager.getDriver().getCurrentUrl();
    return currentUrl.contains(CREATE_PROFILE_URL);
  }

  public void selectTitle(String titleValue) {
    waitForClickableAndClick(titleDropdown);
    waitForVisibilityAndClickByLocator(By.xpath("//option[@value='" + titleValue + "']"), 15);
  }

  public void enterNameCredentials(User user) {
    waitForVisibilityAndSendKeys(firstNameInput, user.getFirstName());
    waitForVisibilityAndSendKeys(lastNameInput, user.getLastName());
  }

  public void selectCountryCode(String code) {
    waitForClickableAndClick(countryCodeDropdown);
    waitForVisibilityAndClickByLocator(By.xpath("//option[@value='" + code + "']"), 15);
  }

  public void enterPhoneNumber(User user) {
    waitForVisibilityAndSendKeys(phoneNumberInput, user.getPhone());
  }

  public void clickRegisterButton() {
    waitForClickableAndClick(registerButton);
  }

  public boolean isTitleDropdownDisplayed() {
    return titleDropdown.isDisplayed();
  }

  public boolean isFirstNameInputDisplayed() {
    return firstNameInput.isDisplayed();
  }

  public boolean isLastNameInputDisplayed() {
    return lastNameInput.isDisplayed();
  }

  public boolean isCountryCodeDropdownDisplayed() {
    return countryCodeDropdown.isDisplayed();
  }

  public boolean isPhoneNumberInputDisplayed() {
    return phoneNumberInput.isDisplayed();
  }

  public boolean isRegisterButtonDisplayed() {
    return registerButton.isDisplayed();
  }
}
