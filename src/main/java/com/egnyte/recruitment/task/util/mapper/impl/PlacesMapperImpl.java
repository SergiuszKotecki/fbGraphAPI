package com.egnyte.recruitment.task.util.mapper.impl;

import com.egnyte.recruitment.task.model.PlaceDTO;
import com.egnyte.recruitment.task.util.mapper.PlacesMapper;
import facebook4j.Place;
import facebook4j.ResponseList;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlacesMapperImpl implements PlacesMapper {

    private PlaceDTO fbPlaceToStandardPlace(Place fbPlace) {
        return PlaceDTO.builder()
                .latitude(fbPlace.getLocation().getLatitude().floatValue())
                .longitude(fbPlace.getLocation().getLongitude().floatValue())
                .name(fbPlace.getName())
                .build();
    }

    @Override
    public List<PlaceDTO> mapFacebookPlacesToStandardPlaces(ResponseList<Place> fbPlaces) {
        return fbPlaces.stream().map(this::fbPlaceToStandardPlace)
                .collect(Collectors.toList());
    }
}
