package org.moy.spring.cloud.weather.service;

import org.moy.spring.cloud.weather.util.XmlBuilderUtil;
import org.moy.spring.cloud.weather.vo.City;
import org.moy.spring.cloud.weather.vo.CityList;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * [Project]:cloud-demo-master  <br/>
 * [Email]:moy25@foxmail.com  <br/>
 * [Date]:2018/4/30  <br/>
 * [Description]:  <br/>
 *
 * @author YeXiangYang
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    @Override
    public List<City> listCity() {
        CityList cityList = XmlBuilderUtil.xmlFileToObject("cityList.xml", CityList.class);
        return cityList.getCityList();
    }
}
