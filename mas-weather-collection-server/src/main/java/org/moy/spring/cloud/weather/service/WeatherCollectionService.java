package org.moy.spring.cloud.weather.service;

/**
 * [Project]:cloud-demo-master  <br/>
 * [Email]:moy25@foxmail.com  <br/>
 * [Date]:2018/4/30  <br/>
 * [Description]:  <br/>
 *
 * @author YeXiangYang
 */
public interface WeatherCollectionService {

    void syncDataByCityId(String cityId);
}
