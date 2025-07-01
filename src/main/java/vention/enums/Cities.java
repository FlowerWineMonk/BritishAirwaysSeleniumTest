package vention.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Cities {
    NEW_YORK("New York", "new-york,-john-f-kennedy-(ny)-(jfk),-usa"),
    LONDON("London", "london,-gatwick-(lgw),-united-kingdom");

    private final String cityName;
    private final String cityAirport;
}
