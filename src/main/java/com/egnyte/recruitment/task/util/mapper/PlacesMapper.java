package com.egnyte.recruitment.task.util.mapper;

import com.egnyte.recruitment.task.model.PlaceDTO;
import facebook4j.Place;
import facebook4j.ResponseList;

import java.util.List;

public interface PlacesMapper {
    List<PlaceDTO> mapFacebookPlacesToStandardPlaces(ResponseList<Place> fbPlaces);
}
