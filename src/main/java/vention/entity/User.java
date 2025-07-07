package vention.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Setter
@Getter
@Builder
public class User {
  private String username;
  private String password;
  private String email;
  private String phone;
  private String firstName;
  private String lastName;
}
