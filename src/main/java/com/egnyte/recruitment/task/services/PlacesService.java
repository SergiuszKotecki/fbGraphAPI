package com.egnyte.recruitment.task.services;

import com.egnyte.recruitment.task.models.Place;
import org.springframework.stereotype.Service;

@Service
public interface PlacesService {

    Place place (String country, String city, String desc);
}
