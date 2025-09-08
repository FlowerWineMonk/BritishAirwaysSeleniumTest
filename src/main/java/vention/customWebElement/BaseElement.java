package vention.customWebElement;

public interface BaseElement {
  void click();

  void sendKeys(String text);

  boolean isDisplayed();

  String getText();
}
