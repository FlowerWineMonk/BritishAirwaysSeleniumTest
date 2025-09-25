package vention.pages;

import vention.customWebElement.CustomWebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

public class HomePage extends BasePage {
  private static final String RELATIVE_PATH = "/travel/home/public/en_us/";

  @FindBy(id = "fare")
  private CustomWebElement fareDropDown;

  @FindBy(id = "from")
  private CustomWebElement fromInput;

  @FindBy(id = "to")
  private CustomWebElement toInput;

  @FindBy(id = "%s")
  private CustomWebElement dynamicAirportOption;

  @FindBy(id = "departureDate")
  private CustomWebElement departureDateButton;

  @FindBy(xpath = "//span[@data-testid='%s']")
  private CustomWebElement dynamicDateOption;

  @FindBy(id = "flight-search-tab-inputs-flights-button-find-flights")
  private CustomWebElement findFlightsButton;

  public HomePage() {
    super();
  }

  @Override
  public String getRelativePath() {
    return RELATIVE_PATH;
  }

  @Step("Select fare type: {fareWay}")
  public void selectFare(String fareWay) {
    fareDropDown.waitForReloadAndSelectByValue(fareWay);
  }

  @Step("Enter departure city: {fromCity} and select airport: {fromCityInfo}")
  public void enterFromDestination(String fromCity, String fromCityInfo) {
    fromInput.clearAndTypeWithReload(fromCity);
    fromInput.waitForReloadAndClickOption(dynamicAirportOption, fromCityInfo);
  }

  @Step("Enter destination city: {toCity} and select airport: {toCityInfo}")
  public void enterToDestination(String toCity, String toCityInfo) {
    toInput.clearAndTypeWithReload(toCity);
    toInput.waitForReloadAndClickOption(dynamicAirportOption, toCityInfo);
  }

  @Step("Select departure date: {date}")
  public void selectDepartureDate(String date) {
    departureDateButton.waitForReloadAndClick();
    departureDateButton.waitForReloadAndClickOption(dynamicDateOption, date);
  }

  @Step("Click find flights")
  public void clickFindFlightsButton() {
    findFlightsButton.waitForReloadAndClick();
  }

  public boolean isSelectFareDisplayed() {
    return fareDropDown.isDisplayed();
  }

  public boolean isFromInputDisplayed() {
    return fromInput.isDisplayed();
  }

  public boolean isToInputDisplayed() {
    return toInput.isDisplayed();
  }

  public boolean isDepartureDateButtonDisplayed() {
    return departureDateButton.isDisplayed();
  }
}
