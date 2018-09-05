package org.moy.spring.cloud.weather.service;

import org.moy.spring.cloud.weather.vo.WeatherResponse;

/**
 * [Project]:springcloud-master  <br/>
 * [Email]:moy25@foxmail.com  <br/>
 * [Date]:2018/4/30  <br/>
 * [Description]:  <br/>
 *
 * @author YeXiangYang
 */
public interface WeatherService {

    WeatherResponse getDataByCityId(String cityId);

    WeatherResponse getDataByCityName(String cityName);

    void syncDataByCityId(String cityId);
}
