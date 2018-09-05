package org.moy.spring.cloud.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * [Project]:cloud-demo-master  <br/>
 * [Email]:moy25@foxmail.com  <br/>
 * [Date]:2018/4/30  <br/>
 * [Description]:  <br/>
 *
 * @author YeXiangYang
 */
public abstract class XmlBuilderUtil {

    public static <T> T xmlFileToObject(String xmlFilePath, Class<T> clazz) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = contextClassLoader.getResourceAsStream(xmlFilePath)) {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            T result = (T) unmarshaller.unmarshal(inputStream);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("将" + xmlFilePath + "文件转化java实体出错!", e);
        }
    }
}
