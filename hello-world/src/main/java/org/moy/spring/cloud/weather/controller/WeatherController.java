package org.moy.spring.cloud.weather.controller;

import org.moy.spring.cloud.weather.service.CityDataService;
import org.moy.spring.cloud.weather.service.WeatherService;
import org.moy.spring.cloud.weather.vo.City;
import org.moy.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * [Project]:springcloud-master  <br/>
 * [Email]:moy25@foxmail.com  <br/>
 * [Date]:2018/4/30  <br/>
 * [Description]:  <br/>
 *
 * @author YeXiangYang
 */
@RestController
@RequestMapping("/weathers")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;
    @Autowired
    private CityDataService cityDataService;

    @GetMapping("/city/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId) {
        WeatherResponse data = weatherService.getDataByCityId(cityId);
        return data;
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName) {
        WeatherResponse data = weatherService.getDataByCityName(cityName);
        return data;
    }

    @GetMapping("/listCity")
    public List<City> listCityInfo() {
        List<City> cityList = cityDataService.listCity();
        return cityList;
    }
}
