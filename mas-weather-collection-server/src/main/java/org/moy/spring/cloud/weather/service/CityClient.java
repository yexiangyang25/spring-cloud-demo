package org.moy.spring.cloud.weather.service;

import org.moy.spring.cloud.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * [Project]:cloud-demo-master  <br/>
 * [Email]:moy25@foxmail.com  <br/>
 * [Date]:2018/5/1  <br/>
 * [Description]:  <br/>
 *
 * @author YeXiangYang
 */
@FeignClient("mas-weather-city-server")
@Component
public interface CityClient {

    @GetMapping("/cities")
    List<City> listCity();
}
