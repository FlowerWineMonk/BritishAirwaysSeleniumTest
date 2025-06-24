package vention.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
  @FindBy(id = "fare")
  private WebElement selectFare;

  @FindBy(id = "from")
  private WebElement fromField;

  @FindBy(id = "to")
  private WebElement toField;

  @FindBy(id = "departureDate")
  private WebElement departureDateField;

  @FindBy(id = "flight-search-tab-inputs-flights-button-find-flights")
  private WebElement findFlightsBtn;

  @FindBy(xpath = "//button[@data-testid='amex-offer-hero-variant-cta-button']")
  private WebElement learnMoreBtn;

  public HomePage() {
    super();
  }

  public void selectFare(String fareWay) {
    waitForVisibilityAndClick(selectFare);
    waitForVisibilityAndClickByLocator(By.xpath("//option[@value='" + fareWay + "']"));
  }

  public void fillFromField(String fromCity, String fromCityInfo) {
    waitForVisibilityAndSendKeys(fromField, fromCity);
    waitForVisibilityAndClickByLocator(By.id(fromCityInfo));
  }

  public void fillToField(String toCity, String toCityInfo) {
    waitForVisibilityAndSendKeys(toField, toCity);
    waitForVisibilityAndClickByLocator(By.id(toCityInfo));
  }

  public void fillDepartureDateAndClick(String date) {
    waitForVisibilityAndClick(departureDateField);
    waitForVisibilityAndClickByLocator(By.xpath("//span[@data-testid='" + date + "']"));
  }

  public void clickFindFlightsBtn() {
    waitForVisibilityAndClick(findFlightsBtn);
  }

  public void clickLearnMoreBtn() {
    waitForVisibilityAndClick(learnMoreBtn);
  }

  public boolean isSelectFareDisplayed() {
    return selectFare.isDisplayed();
  }

  public boolean isFromFieldDisplayed() {
    return fromField.isDisplayed();
  }

  public boolean isToFieldDisplayed() {
    return toField.isDisplayed();
  }

  public boolean isDepartureDateFieldDisplayed() {
    return departureDateField.isDisplayed();
  }

  public boolean isFindFlightsBtnDisplayed() {
    return findFlightsBtn.isDisplayed();
  }

  public boolean isLearnMoreBtnDisplayed() {
    return learnMoreBtn.isDisplayed();
  }
}
