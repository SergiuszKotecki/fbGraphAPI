package com.egnyte.recruitment.task.service.impl;

import com.egnyte.recruitment.task.config.FacebookClient;
import com.egnyte.recruitment.task.model.PlaceDTO;
import com.egnyte.recruitment.task.service.PlacesService;
import com.egnyte.recruitment.task.util.OpenStreetMapUtils;
import com.egnyte.recruitment.task.util.mapper.PlacesMapper;
import facebook4j.FacebookException;
import facebook4j.GeoLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class PlacesServiceImpl implements PlacesService {

    @Autowired
    FacebookClient facebookCfg;

    @Autowired
    PlacesMapper placesMapper;

    @Override
    public List<PlaceDTO> place(String country, String city, String desc) throws FacebookException {
        Map<String, Double> coords;
        coords = OpenStreetMapUtils.getInstance().getCoordinates(country + " " + city);
        GeoLocation location = new GeoLocation(coords.get("lat"), coords.get("lon"));
        int distanceFromLocation = 700;

        return placesMapper.mapFacebookPlacesToStandardPlaces(facebookCfg.facebook()
                .search()
                .searchPlaces(desc, location, distanceFromLocation));

    }
}
