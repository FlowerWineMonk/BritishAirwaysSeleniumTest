package vention.configLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
  private static final Properties properties = new Properties();
  private static final String CONFIG_FILE_PATH = "src/test/config/application.properties";

  static {
      try (FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)){
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
