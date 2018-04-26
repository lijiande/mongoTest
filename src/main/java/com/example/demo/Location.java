package com.example.demo;


import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Location {

    @Id
    private String id;

    private Date signalTime;

    private Date locationTime;

    private String latitude;

    private String longitude;

    private String speed;

    private String direction;

    private String locateType;

    private Integer isOnline;

    private Integer onlineType;

    private String deviceImei;

    private String deviceType;

    private String electric;

    private Date upStatusTime;

    private Date updateTime;

    private String thirdId;

    private String crop;


}
