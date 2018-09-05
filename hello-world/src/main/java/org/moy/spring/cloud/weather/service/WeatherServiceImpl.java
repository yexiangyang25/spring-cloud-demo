package org.moy.spring.cloud.weather.service;

import org.moy.spring.cloud.weather.constants.WeatherConst;
import org.moy.spring.cloud.weather.util.JsonUtil;
import org.moy.spring.cloud.weather.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * [Project]:springcloud-master  <br/>
 * [Email]:moy25@foxmail.com  <br/>
 * [Date]:2018/4/30  <br/>
 * [Description]:  <br/>
 *
 * @author YeXiangYang
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final static long REDIS_STORE_TIMEOUT = 1800L;

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
            ResponseEntity<String> entityString = restTemplate.getForEntity(key, String.class);
            jsonData = entityString.getBody();
            opsForValue.set(key, jsonData, REDIS_STORE_TIMEOUT, TimeUnit.SECONDS);
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

    @Override
    public void syncDataByCityId(String cityId) {
        String uri = WeatherConst.DATA_BY_CITY_ID_HTTP_URL + cityId;
        ResponseEntity<String> entityString = restTemplate.getForEntity(uri, String.class);

        String jsonData = "";
        if (Objects.nonNull(entityString)) {
            if (entityString.getStatusCode().is2xxSuccessful()) {
                jsonData = entityString.getBody();
            }
        }
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        opsForValue.set(uri, jsonData, REDIS_STORE_TIMEOUT, TimeUnit.SECONDS);
    }
}
