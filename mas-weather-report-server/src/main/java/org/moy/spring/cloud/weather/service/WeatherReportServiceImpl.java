package org.moy.spring.cloud.weather.service;

import org.moy.spring.cloud.weather.vo.Weather;
import org.moy.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * [Project]:cloud-demo-master  <br/>
 * [Email]:moy25@foxmail.com  <br/>
 * [Date]:2018/4/30  <br/>
 * [Description]:  <br/>
 *
 * @author YeXiangYang
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private DataClient dataClient;;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse data = dataClient.getWeatherByCityId(cityId);
        return data.getData();
    }
}
