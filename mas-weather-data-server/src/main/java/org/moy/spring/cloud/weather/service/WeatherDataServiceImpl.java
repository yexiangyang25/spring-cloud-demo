package org.moy.spring.cloud.weather.service;

import org.moy.spring.cloud.weather.constants.WeatherConst;
import org.moy.spring.cloud.weather.util.JsonUtil;
import org.moy.spring.cloud.weather.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;


/**
 * [Project]:springcloud-master  <br/>
 * [Email]:moy25@foxmail.com  <br/>
 * [Date]:2018/4/30  <br/>
 * [Description]:  <br/>
 *
 * @author YeXiangYang
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        try {
            String uri = WeatherConst.DATA_BY_CITY_ID_HTTP_URL + cityId;
            String jsonData = getDataByKeyFromCache(uri);
            WeatherResponse response = JsonUtil.fromJsonString(jsonData, WeatherResponse.class);
            return response;
        } catch (Exception e) {
            LOGGER.error("获取天气根据cityId出错!", e);
            throw e;
        }
    }

    private String getDataByKeyFromCache(String key) {
        String jsonData = "";
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        if (stringRedisTemplate.hasKey(key)) {
            LOGGER.info("Data from Redis!");
            jsonData = opsForValue.get(key);
        } else {
            LOGGER.info("Data not from Redis!");
            throw new RuntimeException("not data in Redis!");
        }
        return jsonData;
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        try {
            String uri = WeatherConst.DATA_BY_CITY_NAME_HTTP_URL + cityName;
            String jsonData = getDataByKeyFromCache(uri);
            WeatherResponse response = JsonUtil.fromJsonString(jsonData, WeatherResponse.class);
            return response;
        } catch (Exception e) {
            LOGGER.error("获取天气根据cityName出错!", e);
            throw e;
        }
    }
}
