package vention.configLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
  private static Properties properties = new Properties();

  static {
   try {
      FileInputStream fis = new FileInputStream("src/test/config/credentials.properties");
      properties.load(fis);
  } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException("Could not load config file");
    }
  }

  public static String get(String key) {
    return properties.getProperty(key);
  }
}
