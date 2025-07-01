package vention.pages;

import vention.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
  private static final String RELATIVE_PATH = "/travel/home/public/en_us/";
  private static final String HOME_URL = "/home";

  @FindBy(id = "fare")
  private WebElement fareDropDown;

  @FindBy(id = "from")
  private WebElement fromInput;

  @FindBy(id = "to")
  private WebElement toInput;

  @FindBy(id = "departureDate")
  private WebElement departureDateButton;

  @FindBy(id = "flight-search-tab-inputs-flights-button-find-flights")
  private WebElement findFlightsButton;

  @FindBy(xpath = "//button[@data-testid='amex-offer-hero-variant-cta-button']")
  private WebElement learnMoreButton;

  public HomePage() {
    super();
  }

  @Override
  public String getRelativePath() {
    return RELATIVE_PATH;
  }

  public boolean isOnHomePage() {
    String currentUrl = DriverManager.getDriver().getCurrentUrl();
    return currentUrl.contains(HOME_URL);
  }

  public void selectFare(String fareWay) {
    waitForClickableAndClick(fareDropDown);
    waitForVisibilityAndClickByLocator(By.xpath("//option[@value='" + fareWay + "']"), 10);
  }

  public void enterFromDestination(String fromCity, String fromCityInfo) {
    waitForVisibilityAndSendKeys(fromInput, fromCity);
    waitForVisibilityAndClickByLocator(By.id(fromCityInfo), 30);
  }

  public void enterToDestination(String toCity, String toCityInfo) {
    waitForVisibilityAndSendKeys(toInput, toCity);
    waitForVisibilityAndClickByLocator(By.id(toCityInfo), 30);
  }

  public void selectDepartureDate(String date) {
    waitForClickableAndClick(departureDateButton);
    waitForVisibilityAndClickByLocator(By.xpath("//span[@data-testid='" + date + "']"), 20);
  }

  public void clickFindFlightsButton() {
    waitForClickableAndClick(findFlightsButton);
  }

  public void clickLearnMoreButton() {
    waitForClickableAndClick(learnMoreButton);
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
