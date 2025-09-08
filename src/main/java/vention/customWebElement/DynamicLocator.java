package vention.customWebElement;

import org.openqa.selenium.By;

public class DynamicLocator {
  private final By locatorTemplate;
  private final String locatorPattern;

  public DynamicLocator(By locatorTemplate, String locatorPattern) {
    this.locatorTemplate = locatorTemplate;
    this.locatorPattern = locatorPattern;
  }

  public By createLocator(String... args) {
    String formattedLocator = String.format(locatorPattern, (Object[]) args);

    if (locatorTemplate.toString().startsWith("By.xpath:")) {
      return By.xpath(formattedLocator);
    } else if (locatorTemplate.toString().startsWith("By.id:")) {
      return By.id(formattedLocator);
    } else if (locatorTemplate.toString().startsWith("By.cssSelector:")) {
      return By.cssSelector(formattedLocator);
    } else if (locatorTemplate.toString().startsWith("By.className:")) {
      return By.className(formattedLocator);
    } else if (locatorTemplate.toString().startsWith("By.name:")) {
      return By.name(formattedLocator);
    } else if (locatorTemplate.toString().startsWith("By.tagName:")) {
      return By.tagName(formattedLocator);
    } else if (locatorTemplate.toString().startsWith("By.linkText:")) {
      return By.linkText(formattedLocator);
    } else if (locatorTemplate.toString().startsWith("By.partialLinkText:")) {
      return By.partialLinkText(formattedLocator);
    }

    return locatorTemplate;
  }

  public String getLocatorPattern() {
    return locatorPattern;
  }
}
