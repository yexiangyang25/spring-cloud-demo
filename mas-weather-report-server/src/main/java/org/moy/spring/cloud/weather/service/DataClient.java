package org.moy.spring.cloud.weather.service;

import org.moy.spring.cloud.weather.vo.City;
import org.moy.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * [Project]:cloud-demo-master  <br/>
 * [Email]:moy25@foxmail.com  <br/>
 * [Date]:2018/5/1  <br/>
 * [Description]:  <br/>
 *
 * @author YeXiangYang
 */
@FeignClient(name = "mas-weather-eureka-client-zuul" , fallback = DataClientFallback.class)
@Component
public interface DataClient {

    @GetMapping("/city/cities")
    List<City> listCity();

    @GetMapping("/data/weathers/city/{cityId}")
    WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId);
}
