package vention.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Cities {
  NEW_YORK("New York", "new-york-john-f-kennedy-ny-jfk-usa_us"),
  LONDON("London", "london-gatwick-lgw-united-kingdom_gb");

  private final String cityName;
  private final String cityAirport;
}
