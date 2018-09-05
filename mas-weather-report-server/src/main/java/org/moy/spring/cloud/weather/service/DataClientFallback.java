package org.moy.spring.cloud.weather.service;

import org.moy.spring.cloud.weather.vo.City;
import org.moy.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * [Project]:cloud-demo-master  <br/>
 * [Email]:moy25@foxmail.com  <br/>
 * [Date]:2018/5/1  <br/>
 * [Description]:  <br/>
 *
 * @author YeXiangYang
 */
@Component
public class DataClientFallback implements DataClient {

    @Override
    public List<City> listCity() {
        return Collections.emptyList();
    }

    @Override
    public WeatherResponse getWeatherByCityId(String cityId) {
        return null;
    }
}
