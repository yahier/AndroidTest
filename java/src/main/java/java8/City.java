package java8;

import java.util.Objects;

/**
 * Created by yahier on 2018/1/24.
 */

public class City {
    String cityName;
    String cityCode;

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof City)) return false;
        City tCity = (City) o;
        return Objects.equals(cityName, tCity.cityName) && Objects.equals(cityCode, tCity.cityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName, cityCode);
    }
}
