package com.chr.web.server;

import javax.jws.WebService;
import javax.ws.rs.*;

@WebService
public class WeatherServiceImpl implements WeatherService{
    @Override
    @GET
    @Path("/queryWeather/{cc}/")
    @Produces("text/plain;charset=UTF-8")
    public String CityWeather(@PathParam(value="cc") String cityName) {
        if("北京".equals(cityName)) {
            return cityName+"雾霾~保重~";
        }
        return cityName+"好~";
    }
}
