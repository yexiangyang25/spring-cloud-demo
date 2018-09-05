package org.moy.spring.cloud.weather.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.moy.spring.cloud.weather.service.CityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * [Project]:cloud-demo-master  <br/>
 * [Email]:moy25@foxmail.com  <br/>
 * [Date]:2018/5/1  <br/>
 * [Description]:  <br/>
 *
 * @author YeXiangYang
 */
@RestController
public class CityController {

    @Autowired
    private CityClient cityClient;

    @GetMapping("/cities")
    @HystrixCommand(fallbackMethod = "defaultListCity")
    public String listCity() {
        String data = cityClient.listCity();
        return data;
    }

    public String defaultListCity() {
        return "City Data Server is done!!";
    }

}
