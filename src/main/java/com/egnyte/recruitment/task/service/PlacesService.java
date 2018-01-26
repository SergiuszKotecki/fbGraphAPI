package com.egnyte.recruitment.task.service;

import com.egnyte.recruitment.task.model.PlaceDTO;
import facebook4j.FacebookException;

import java.util.List;

public interface PlacesService {
    List<PlaceDTO> place (String country, String city, String desc) throws FacebookException;
}
