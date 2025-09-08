package vention.pages;

import vention.customWebElement.CustomWebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;
import vention.utils.WaitUtils;

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
    CustomWebElement reloadedFare = WaitUtils.waitForElementReload(fareDropDown, 10);
    reloadedFare.asSelect().selectByValue(fareWay);
  }

  @Step("Enter departure city: {fromCity} and select airport: {fromCityInfo}")
  public void enterFromDestination(String fromCity, String fromCityInfo) {
    CustomWebElement reloadedFromInput = WaitUtils.waitForElementReload(fromInput, 10);
    reloadedFromInput.getWrappedElement().clear();
    reloadedFromInput.sendKeys(fromCity);

    CustomWebElement reloadedAirportOption = WaitUtils.waitForElementReload(
        dynamicAirportOption.withArgs(fromCityInfo), 10);
    reloadedAirportOption.click();
  }

  @Step("Enter destination city: {toCity} and select airport: {toCityInfo}")
  public void enterToDestination(String toCity, String toCityInfo) {
    CustomWebElement reloadedToInput = WaitUtils.waitForElementReload(toInput, 10);
    reloadedToInput.getWrappedElement().clear();
    reloadedToInput.sendKeys(toCity);

    CustomWebElement reloadedAirportOption = WaitUtils.waitForElementReload(
        dynamicAirportOption.withArgs(toCityInfo), 10);
    reloadedAirportOption.click();
  }

  @Step("Select departure date: {date}")
  public void selectDepartureDate(String date) {
    CustomWebElement reloadedDepartureDateButton = WaitUtils.waitForElementReload(departureDateButton, 5);
    reloadedDepartureDateButton.click();

    CustomWebElement reloadedDateOption = WaitUtils.waitForElementReload(
        dynamicDateOption.withArgs(date), 5);
    reloadedDateOption.click();
  }

  @Step("Click find flights")
  public void clickFindFlightsButton() {
    CustomWebElement reloadedFindFlightsButton = WaitUtils.waitForElementReload(findFlightsButton, 5);
    reloadedFindFlightsButton.click();
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
