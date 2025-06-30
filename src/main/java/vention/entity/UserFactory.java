package vention.entity;

import com.github.javafaker.Faker;
import io.github.cdimascio.dotenv.Dotenv;

public class UserFactory {
  private static final Faker faker = new Faker();

  public static User getExistingUser() {
    Dotenv dotenv = Dotenv.load();
    return User.builder()
            .email(dotenv.get("EXISTING_USER_EMAIL"))
            .password(dotenv.get("EXISTING_USER_PASSWORD")).build();
  }

  public static User getRandomUser() {
    return User.builder()
            .username(faker.name().username())
            .password(faker.internet().password())
            .email(faker.internet().emailAddress())
            .phone(faker.phoneNumber().cellPhone())
            .firstName(faker.name().firstName())
            .lastName(faker.name().lastName())
            .build();
  }
}
