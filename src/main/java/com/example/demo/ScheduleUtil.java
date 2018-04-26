package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Component
@EnableScheduling
public class ScheduleUtil {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private CommonConfig commonConfig;


    @Scheduled(cron = "0/10 * * * * ?")
    private void run() {
        int theadNum = commonConfig.getOrSetThreadNum(null);
        int num = commonConfig.getOrSetNum(null);
        for (int i = 0; i < theadNum; i++) {
            Thread t = new Thread(() -> {
                for (int i1 = 0; i1 < num; i1++) {
                    Location location = new Location();
                    location.setId(UUID.randomUUID().toString());
                    location.setSignalTime(new Date());
                    location.setLocationTime(new Date());
                    location.setLatitude("121.22222222");
                    location.setLongitude("122.3333333");
                    location.setSpeed(String.valueOf(new Random().nextDouble()));
                    location.setDirection(String.valueOf(new Random().nextDouble()));
                    location.setLocateType("GPS");
                    location.setIsOnline(new Random().nextBoolean() ? 1 : 0);
                    location.setOnlineType(new Random().nextBoolean() ? 1 : 0);
                    location.setDeviceImei("1234567890");
                    location.setDeviceType(new Random().nextBoolean() ? "无线" : "有线");
                    location.setElectric("99");
                    location.setUpStatusTime(new Date());
                    location.setThirdId("a");
                    location.setCrop("zgx");
                    save(location);
                }
            });
            t.start();
        }
    }

    @Async
    void save(Location location) {
        locationRepository.save(location);
    }
}
