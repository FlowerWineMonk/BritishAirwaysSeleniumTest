package vention.pages;

import vention.customWebElement.WebElementImp;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
  private static final String RELATIVE_PATH = "/travel/home/public/en_us/";

  @FindBy(id = "fare")
  private WebElementImp fareDropDown;

  @FindBy(id = "from")
  private WebElementImp fromInput;

  @FindBy(id = "to")
  private WebElementImp toInput;

  @FindBy(id = "departureDate")
  private WebElementImp departureDateButton;

  @FindBy(id = "flight-search-tab-inputs-flights-button-find-flights")
  private WebElementImp findFlightsButton;

  @FindBy(xpath = "//button[@data-testid='amex-offer-hero-variant-cta-button']")
  private WebElementImp learnMoreButton;

  public HomePage() {
    super();
  }

  @Override
  public String getRelativePath() {
    return RELATIVE_PATH;
  }

  public void selectFare(String fareWay) {
    fareDropDown.click();
    WebElementImp.clickByLocator(By.xpath("//option[@value='" + fareWay + "']"), 10);
  }

  public void enterFromDestination(String fromCity, String fromCityInfo) {
    fromInput.sendKeys(fromCity);
    WebElementImp.clickByLocator(By.id(fromCityInfo), 30);
  }

  public void enterToDestination(String toCity, String toCityInfo) {
    toInput.sendKeys(toCity);
    WebElementImp.clickByLocator(By.id(toCityInfo), 30);
  }

  public void selectDepartureDate(String date) {
    departureDateButton.click();
    WebElementImp.clickByLocator(By.xpath("//span[@data-testid='" + date + "']"), 20);
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
