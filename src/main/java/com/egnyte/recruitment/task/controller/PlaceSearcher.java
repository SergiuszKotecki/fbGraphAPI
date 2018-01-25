package com.egnyte.recruitment.task.controller;


import com.egnyte.recruitment.task.service.PlacesService;
import facebook4j.FacebookException;
import facebook4j.Place;
import facebook4j.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceSearcher {

    @Autowired
    PlacesService placesService;

    @GetMapping(value = "/{country}/{city}/{description}")
    public ResponseList<Place> getPlaceByCountryCityAndDesc(@PathVariable("country") String country,
                                                              @PathVariable("city") String city,
                                                              @PathVariable("description") String description) throws FacebookException {
        ResponseList<facebook4j.Place> places = placesService.place(country, city, description);
        return places;

    }


}
