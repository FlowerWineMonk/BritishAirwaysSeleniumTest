package vention.pages;

import vention.customWebElement.CustomWebElement;
import org.openqa.selenium.support.FindBy;
import vention.entity.User;
import io.qameta.allure.Step;

public class CreateProfilePage extends BasePage {
  private static final String RELATIVE_PATH = "/register";
  private static final String TITLE_DROPDOWN_CSS = "#title option[value='Mr']";
  private static final String COUNTRY_CODE_DROPDOWN_CSS = "#countrycode option[value='+1']";

  @FindBy(id = "title")
  private CustomWebElement titleDropdown;

  @FindBy(id = "firstname--inputtext--input")
  private CustomWebElement firstNameInput;

  @FindBy(id = "lastname--inputtext--input")
  private CustomWebElement lastNameInput;

  @FindBy(id = "countrycode")
  private CustomWebElement countryCodeDropdown;

  @FindBy(id = "phoneNumber--inputtext--input")
  private CustomWebElement phoneNumberInput;

  @FindBy(xpath = "//button[@data-testid='register-submit-button']")
  private CustomWebElement registerButton;

  @Override
  public String getRelativePath() {
    return RELATIVE_PATH;
  }

  public CreateProfilePage() {
    super();
  }

  @Step("Select title")
  public void selectTitle(String titleValue) {
    titleDropdown.customSelect(titleDropdown, titleValue, TITLE_DROPDOWN_CSS, 10);
  }

  @Step("Enter name credentials: first name and last name")
  public void enterNameCredentials(User user) {
    firstNameInput.sendKeys(user.getFirstName());
    lastNameInput.sendKeys(user.getLastName());
  }

  @Step("Select country code")
  public void selectCountryCode(String countryCodeValue) {
    countryCodeDropdown.customSelect(countryCodeDropdown, countryCodeValue, COUNTRY_CODE_DROPDOWN_CSS, 10);
  }

  @Step("Enter phone number")
  public void enterPhoneNumber(User user) {
    phoneNumberInput.sendKeys(user.getPhone());
  }

  @Step("Click register button")
  public void clickRegisterButton() {
    registerButton.click();
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
