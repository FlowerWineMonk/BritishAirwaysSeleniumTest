package vention.pages;

import vention.WebElementImp.CustomElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
  private static final String RELATIVE_PATH = "/travel/home/public/en_us/";

  @FindBy(id = "fare")
  private CustomElement fareDropDown;

  @FindBy(id = "from")
  private CustomElement fromInput;

  @FindBy(id = "to")
  private CustomElement toInput;

  @FindBy(id = "departureDate")
  private CustomElement departureDateButton;

  @FindBy(id = "flight-search-tab-inputs-flights-button-find-flights")
  private CustomElement findFlightsButton;

  @FindBy(xpath = "//button[@data-testid='amex-offer-hero-variant-cta-button']")
  private CustomElement learnMoreButton;

  public HomePage() {
    super();
  }

  @Override
  public String getRelativePath() {
    return RELATIVE_PATH;
  }

  public void selectFare(String fareWay) {
    fareDropDown.click();
    CustomElement.clickByLocator(By.xpath("//option[@value='" + fareWay + "']"), 10);
  }

  public void enterFromDestination(String fromCity, String fromCityInfo) {
    fromInput.sendKeys(fromCity);
    CustomElement.clickByLocator(By.id(fromCityInfo), 30);
  }

  public void enterToDestination(String toCity, String toCityInfo) {
    toInput.sendKeys(toCity);
    CustomElement.clickByLocator(By.id(toCityInfo), 30);
  }

  public void selectDepartureDate(String date) {
    departureDateButton.click();
    CustomElement.clickByLocator(By.xpath("//span[@data-testid='" + date + "']"), 20);
  }

  public void clickFindFlightsButton() {
    findFlightsButton.click();
  }

  public void clickLearnMoreButton() {
    learnMoreButton.click();
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

  public boolean isFindFlightsButtonDisplayed() {
    return findFlightsButton.isDisplayed();
  }

  public boolean isLearnMoreButtonDisplayed() {
    return learnMoreButton.isDisplayed();
  }
}
