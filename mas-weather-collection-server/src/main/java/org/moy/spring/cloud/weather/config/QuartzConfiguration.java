package org.moy.spring.cloud.weather.config;

import org.moy.spring.cloud.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * [Project]:springcloud-master  <br/>
 * [Email]:moy25@foxmail.com  <br/>
 * [Date]:2018/4/30  <br/>
 * [Description]:  <br/>
 *
 * @author YeXiangYang
 */
@Configuration
public class QuartzConfiguration {

    // JobDetail
    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        JobDetail jobDetail = JobBuilder.newJob(WeatherDataSyncJob.class)
                .withIdentity("WeatherDataSyncJob")
                .storeDurably()
                .build();

        return jobDetail;
    }

    // Trigger
    @Bean
    public Trigger weatherDataSyncTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(1800).repeatForever();

        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger")
                .withSchedule(scheduleBuilder)
                .build();

        return trigger;
    }
}
