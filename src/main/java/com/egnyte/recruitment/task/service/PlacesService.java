package com.egnyte.recruitment.task.service;

import facebook4j.FacebookException;
import facebook4j.Place;
import facebook4j.ResponseList;

public interface PlacesService {
    ResponseList<Place> place (String country, String city, String desc) throws FacebookException;
}
