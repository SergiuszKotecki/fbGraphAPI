package com.egnyte.recruitment.task.service.impl;

import com.egnyte.recruitment.task.config.FacebookClient;
import com.egnyte.recruitment.task.service.PlacesService;
import com.egnyte.recruitment.task.util.OpenStreetMapUtils;
import facebook4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class PlacesServiceImpl implements PlacesService {

    @Autowired
    FacebookClient facebookCfg;


    @Override
    public ResponseList<Place> place(String country, String city, String desc) throws FacebookException {
        Map<String, Double> coords;
        coords = OpenStreetMapUtils.getInstance().getCoordinates(country + " " + city);
        GeoLocation center = new GeoLocation(coords.get("lat"), coords.get("lon"));
        int distanceFromCenter = 500;
        System.out.println("latitude :" + coords.get("lat"));
        System.out.println("longitude:" + coords.get("lon"));
        return facebookCfg.facebook().search().searchPlaces(desc, center, distanceFromCenter);
    }
}
