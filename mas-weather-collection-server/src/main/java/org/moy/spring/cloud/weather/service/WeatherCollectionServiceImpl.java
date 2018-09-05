package org.moy.spring.cloud.weather.service;

import org.moy.spring.cloud.weather.constants.WeatherConst;
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
 * [Project]:cloud-demo-master  <br/>
 * [Email]:moy25@foxmail.com  <br/>
 * [Date]:2018/4/30  <br/>
 * [Description]:  <br/>
 *
 * @author YeXiangYang
 */
@Service
public class WeatherCollectionServiceImpl implements WeatherCollectionService {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final static long REDIS_STORE_TIMEOUT = 1800L;

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
