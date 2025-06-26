package vention.entity;

import com.github.javafaker.Faker;
import io.github.cdimascio.dotenv.Dotenv;

public class UserFactory {
  private static final Faker faker = new Faker();

  public static User getExistingUser() {
    Dotenv dotenv = Dotenv.load();
    return new User.Builder()
            .email(dotenv.get("EXISTING_USER_EMAIL"))
            .password(dotenv.get("EXISTING_USER_PASSWORD")).build();
  }

  public static User createRandomUser() {
    return new User.Builder()
            .username(faker.name().username())
            .password(faker.internet().password())
            .email(faker.internet().emailAddress())
            .phone(faker.phoneNumber().cellPhone())
            .build();
  }
}
