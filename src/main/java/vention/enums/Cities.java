package vention.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Cities {
  NEW_YORK("New York", "from-option-new-york,-john-f-kennedy-(ny)-(jfk),-usa"),
  LONDON("London", "to-option-london,-gatwick-(lgw),-united-kingdom");

  private final String cityName;
  private final String cityAirport;
}
