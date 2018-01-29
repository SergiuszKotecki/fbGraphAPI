package com.egnyte.recruitment.task;


import com.egnyte.recruitment.task.config.FacebookClient;
import com.egnyte.recruitment.task.model.PlaceDTO;
import com.egnyte.recruitment.task.service.PlacesService;
import com.egnyte.recruitment.task.util.OpenStreetMapUtils;
import facebook4j.FacebookException;
import facebook4j.GeoLocation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PlacesServiceTests {

    @Autowired
    PlacesService placesService;

    @Autowired
    FacebookClient facebookClient;

    @Test
    public void geoConverterReturnGeocoordsForWarsaw() {

        Map<String, Double> coords = OpenStreetMapUtils.getInstance().getCoordinates("Warszawa");
        GeoLocation target = new GeoLocation(coords.get("lat"), coords.get("lon"));
        GeoLocation source = new GeoLocation(52.2319237, 21.0067265);

        Assert.assertEquals(target, source);
    }

    @Test
    public void findEgnyteInPoznan() throws FacebookException {
        List<PlaceDTO> place = placesService.place("Poland", "Poznan", "Egnyte");
        Assert.assertTrue(place.stream().findAny().filter(a -> Objects.equals(a.getName(), "Egnyte Poland")).isPresent());
    }

    @Test
    public void accessTokenIsNotExpired() {
        boolean expired;
        try {
            expired = facebookClient.facebook().getOAuthAccessTokenInfo().getExpires() >0;
        } catch (FacebookException e) {
            expired = false;
        }
        Assert.assertTrue(expired);
    }


}
