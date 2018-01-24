package com.egnyte.recruitment.task.controllers;


import com.egnyte.recruitment.task.models.Place;
import com.egnyte.recruitment.task.services.PlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceSearcher {

    @Autowired
    PlacesService placesService;

    @GetMapping(value = "/{country}/{city}/{description}")
    public HttpEntity<Place> getPlaceByCountryCityAndDesc
            (@PathVariable("country") String country,
             @PathVariable("city") String city,
             @PathVariable("description") String description){

        /*Place.builder()
                .*/

        return new ResponseEntity<Place>(HttpStatus.OK);
    }


}
