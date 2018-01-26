package com.egnyte.recruitment.task.controller;


import com.egnyte.recruitment.task.model.PlaceDTO;
import com.egnyte.recruitment.task.service.PlacesService;
import facebook4j.FacebookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaceSearcher {

    @Autowired
    PlacesService placesService;

    @GetMapping(value = "/{country}/{city}/{description}")
    public List<PlaceDTO> getPlaceByCountryCityAndDesc(@PathVariable("country") String country,
                                                       @PathVariable("city") String city,
                                                       @PathVariable("description") String description) throws FacebookException {

        return placesService.place(country, city, description);
    }


}
