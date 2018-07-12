package com.chr.web.server;

import javax.jws.WebService;

@WebService
public interface WeatherService {
    String CityWeather(String cityName);
}
