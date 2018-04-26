package com.example.demo;

import org.springframework.stereotype.Repository;

/**
 * Created by lijian on 2018/4/11.
 */

@Repository
public class LocationRepository extends MongodbDaoImpl<Location> {
    @Override
    public Class<Location> getEntityClass() {
        return null;
    }
}
