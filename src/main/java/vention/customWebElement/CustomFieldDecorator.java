package vention.customWebElement;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CustomFieldDecorator extends DefaultFieldDecorator {
  public CustomFieldDecorator(SearchContext context) {
    super(new DefaultElementLocatorFactory(context));
  }

  @Override
  public Object decorate(ClassLoader loader, Field field) {
    Class<?> type = field.getType();

    ElementLocator locator = factory.createLocator(field);
    if (locator == null) {
      return null;
    }

    if (BaseElement.class.isAssignableFrom(type)) {
      WebElement element = proxyForLocator(loader, locator);
      return wrapElement(type, element);
    }
    return super.decorate(loader, field);
  }

  public Object wrapElement(Class<?> type, WebElement element) {
    try {
      Constructor<?> constr = type.getConstructor(WebElement.class);
      return constr.newInstance(element);
    } catch (Exception e) {
      throw new RuntimeException("Failed to wrap" + type.getName(), e);
    }
  }
}
