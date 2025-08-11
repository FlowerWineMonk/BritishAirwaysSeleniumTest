package vention.entity;

import com.github.javafaker.Faker;

public class UserFactory {
  private static final Faker faker = new Faker();

  public static User getExistingUser() {
    return User.builder()
        .email("abc123ABC@gmail.com")
        .password("abc123ABC").build();
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
