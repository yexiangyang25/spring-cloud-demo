package org.moy.spring.cloud.weather.job;

import org.moy.spring.cloud.weather.service.CityDataService;
import org.moy.spring.cloud.weather.service.WeatherService;
import org.moy.spring.cloud.weather.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * [Project]:springcloud-master  <br/>
 * [Email]:moy25@foxmail.com  <br/>
 * [Date]:2018/4/30  <br/>
 * [Description]:  <br/>
 *
 * @author YeXiangYang
 */
public class WeatherDataSyncJob extends QuartzJobBean {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private CityDataService cityDataService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        LOGGER.info("Weather Data Sync Job Start --->");
        List<City> cityList = cityDataService.listCity();
        for (City city : cityList) {
            String cityId = city.getCityId();
            weatherService.syncDataByCityId(cityId);
        }
        LOGGER.info("Weather Data Sync Job End ---!");
    }
}
