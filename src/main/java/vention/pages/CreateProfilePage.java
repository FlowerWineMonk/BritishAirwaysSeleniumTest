package vention.pages;

import vention.customWebElement.WebElementImp;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import vention.entity.User;

public class CreateProfilePage extends BasePage {
  private static final String RELATIVE_PATH = "/register";

  @FindBy(id = "title")
  private WebElementImp titleDropdown;

  @FindBy(id = "firstname--inputtext--input")
  private WebElementImp firstNameInput;

  @FindBy(id = "lastname--inputtext--input")
  private WebElementImp lastNameInput;

  @FindBy(id = "countrycode")
  private WebElementImp countryCodeDropdown;

  @FindBy(id = "phoneNumber--inputtext--input")
  private WebElementImp phoneNumberInput;

  @FindBy(xpath = "//button[@data-testid='register-submit-button']")
  private WebElementImp registerButton;

  @Override
  public String getRelativePath() {
    return RELATIVE_PATH;
  }

  public CreateProfilePage() {
    super();
  }

  public void selectTitle(String titleValue) {
    titleDropdown.click();
    WebElementImp.clickByLocator(By.xpath("//option[@value='" + titleValue + "']"), 15);
  }

  public void enterNameCredentials(User user) {
    firstNameInput.sendKeys(user.getFirstName());
    lastNameInput.sendKeys(user.getLastName());
  }

  public void selectCountryCode(String code) {
    countryCodeDropdown.click();
    WebElementImp.clickByLocator(By.xpath("//option[@value='" + code + "']"), 15);
  }

  public void enterPhoneNumber(User user) {
    phoneNumberInput.sendKeys(user.getPhone());
  }

  public void clickRegisterButton() {
    registerButton.click();;
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
