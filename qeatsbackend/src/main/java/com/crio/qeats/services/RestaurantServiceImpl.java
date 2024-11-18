
/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.services;

import com.crio.qeats.dto.Restaurant;
import com.crio.qeats.exchanges.GetRestaurantsRequest;
import com.crio.qeats.exchanges.GetRestaurantsResponse;
import com.crio.qeats.repositoryservices.RestaurantRepositoryService;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Service
@Log4j2
public class RestaurantServiceImpl implements RestaurantService {

  private final Double peakHoursServingRadiusInKms = 3.0;
  private final Double normalHoursServingRadiusInKms = 5.0;
  @Autowired
  private RestaurantRepositoryService restaurantRepositoryService;


  // TODO: CRIO_TASK_MODULE_RESTAURANTSAPI - Implement findAllRestaurantsCloseby.
  // Check RestaurantService.java file for the interface contract.
  @Override
  public GetRestaurantsResponse findAllRestaurantsCloseBy(
      GetRestaurantsRequest getRestaurantsRequest, LocalTime currentTime) {
        Double latitude = getRestaurantsRequest.getLatitude();
        Double longitude = getRestaurantsRequest.getLongitude();
        Double peakHours;
      if((currentTime.compareTo(LocalTime.parse("08:00")) >= 0 && currentTime.compareTo(LocalTime.parse("10:00")) <= 0) || 
          (currentTime.compareTo(LocalTime.parse("13:00")) >= 0 && currentTime.compareTo(LocalTime.parse("14:00")) <= 0) || 
          (currentTime.compareTo(LocalTime.parse("19:00")) >= 0 && currentTime.compareTo(LocalTime.parse("21:00")) <= 0))
      peakHours = peakHoursServingRadiusInKms;
      else
      peakHours = normalHoursServingRadiusInKms;
      List<Restaurant> resList= restaurantRepositoryService.findAllRestaurantsCloseBy(latitude, longitude, currentTime, peakHours);
      GetRestaurantsResponse response;
      
      if(resList.isEmpty()) {
        response = new GetRestaurantsResponse(new ArrayList());
      } else {
        response = new GetRestaurantsResponse(resList);
      }
     return response;
  }


}

