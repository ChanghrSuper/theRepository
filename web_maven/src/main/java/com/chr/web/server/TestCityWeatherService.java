package com.chr.web.server;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class TestCityWeatherService {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws",new WeatherServiceImpl());
    }
}
