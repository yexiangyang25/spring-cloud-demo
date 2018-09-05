package org.moy.spring.cloud.weather.controller;

import org.moy.spring.cloud.weather.service.CityDataService;
import org.moy.spring.cloud.weather.service.WeatherReportService;
import org.moy.spring.cloud.weather.service.WeatherService;
import org.moy.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * [Project]:cloud-demo-master  <br/>
 * [Email]:moy25@foxmail.com  <br/>
 * [Date]:2018/4/30  <br/>
 * [Description]:  <br/>
 *
 * @author YeXiangYang
 */
@Controller
@RequestMapping("/weatherReport")
public class WeatherReportController {
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private CityDataService cityDataService;
    @Autowired
    private WeatherReportService weatherReportService;

    @GetMapping("/city/{cityId}")
    public ModelAndView getWeatherByCityId(@PathVariable("cityId") String cityId, Model model) {
        WeatherResponse data = weatherService.getDataByCityId(cityId);
        model.addAttribute("title", "天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityDataService.listCity());
        model.addAttribute("report", weatherReportService.getDateByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }
}
