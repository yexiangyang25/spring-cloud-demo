package org.moy.spring.cloud.weather.service;

import org.moy.spring.cloud.weather.vo.City;

import java.io.IOException;
import java.util.List;

/**
 * [Project]:cloud-demo-master  <br/>
 * [Email]:moy25@foxmail.com  <br/>
 * [Date]:2018/4/30  <br/>
 * [Description]:  <br/>
 *
 * @author YeXiangYang
 */
public interface CityDataService {

    List<City> listCity();
}
