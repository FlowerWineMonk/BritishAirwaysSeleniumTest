package vention.customWebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CustomFieldDecorator extends DefaultFieldDecorator {

  public CustomFieldDecorator(SearchContext context) {
    super(new DefaultElementLocatorFactory(context));
  }

  @Override
  public Object decorate(ClassLoader loader, Field field) {
    Class<?> type = field.getType();

    if (BaseElement.class.isAssignableFrom(type)) {
      By locator = extractLocator(field);
      if (locator != null) {
        String locatorPattern = extractLocatorPattern(locator);
        DynamicLocator dynamicLocator = new DynamicLocator(locator, locatorPattern);
        return wrapElement(type, dynamicLocator);
      }
    }

    return super.decorate(loader, field);
  }

  private By extractLocator(Field field) {
    FindBy findBy = field.getAnnotation(FindBy.class);
    if (findBy == null)
      return null;

    if (!findBy.xpath().isEmpty()) {
      return By.xpath(findBy.xpath());
    } else if (!findBy.id().isEmpty()) {
      return By.id(findBy.id());
    } else if (!findBy.css().isEmpty()) {
      return By.cssSelector(findBy.css());
    } else if (!findBy.className().isEmpty()) {
      return By.className(findBy.className());
    } else if (!findBy.name().isEmpty()) {
      return By.name(findBy.name());
    } else if (!findBy.tagName().isEmpty()) {
      return By.tagName(findBy.tagName());
    } else if (!findBy.linkText().isEmpty()) {
      return By.linkText(findBy.linkText());
    } else if (!findBy.partialLinkText().isEmpty()) {
      return By.partialLinkText(findBy.partialLinkText());
    }

    return null;
  }

  private String extractLocatorPattern(By locator) {
    String locatorString = locator.toString();

    if (locatorString.startsWith("By.xpath: ")) {
      return locatorString.substring("By.xpath: ".length());
    } else if (locatorString.startsWith("By.id: ")) {
      return locatorString.substring("By.id: ".length());
    } else if (locatorString.startsWith("By.cssSelector: ")) {
      return locatorString.substring("By.cssSelector: ".length());
    } else if (locatorString.startsWith("By.className: ")) {
      return locatorString.substring("By.className: ".length());
    } else if (locatorString.startsWith("By.name: ")) {
      return locatorString.substring("By.name: ".length());
    } else if (locatorString.startsWith("By.tagName: ")) {
      return locatorString.substring("By.tagName: ".length());
    } else if (locatorString.startsWith("By.linkText: ")) {
      return locatorString.substring("By.linkText: ".length());
    } else if (locatorString.startsWith("By.partialLinkText: ")) {
      return locatorString.substring("By.partialLinkText: ".length());
    }

    return locatorString;
  }

  public Object wrapElement(Class<?> type, DynamicLocator dynamicLocator) {
    try {
      Constructor<?> constr = type.getConstructor(DynamicLocator.class);
      return constr.newInstance(dynamicLocator);
    } catch (Exception e) {
      try {
        Constructor<?> constr = type.getConstructor(WebElement.class);
        return constr.newInstance((WebElement) null);
      } catch (Exception ex) {
        throw new RuntimeException("Failed to wrap " + type.getName(), e);
      }
    }
  }
}
