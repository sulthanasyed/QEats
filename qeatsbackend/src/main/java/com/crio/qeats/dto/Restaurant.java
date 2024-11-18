
/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.internal.connection.Time;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: CRIO_TASK_MODULE_SERIALIZATION
//  Implement Restaurant class.
// Complete the class such that it produces the following JSON during serialization.
// {
//  "restaurantId": "10",
//  "name": "A2B",
//  "city": "Hsr Layout",
//  "imageUrl": "www.google.com",
//  "latitude": 20.027,
//  "longitude": 30.0,
//  "opensAt": "18:00",
//  "closesAt": "23:00",
//  "attributes": [
//    "Tamil",
//    "South Indian"
//  ]
// }
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurant {
    @JsonProperty("restaurantId")
    String restaurantId;
    
    @JsonProperty("name")
    String name;

    @JsonProperty("city")
    String city;

    @JsonProperty("imageUrl")
    String imageUrl;
    
    @JsonProperty("latitude")
    double latitude;

    @JsonProperty("longitude")
    double longitude;
    
    @JsonProperty("opensAt")
    String opensAt;

    @JsonProperty("closesAt")
    String closesAt;

    @JsonProperty("attributes")
     List<String> attributes;
     public Restaurant(){

     }

 public  Restaurant(String restaurantId, String name, String city, String imageUrl, double latitude, double longitude
 , String opensAt, String closesAt, List<String> attributes){
    this.restaurantId = restaurantId;
    this.name = name;
    this.city = city;
    this.imageUrl = imageUrl;
    this.latitude = latitude;
    this.longitude = longitude;
    this.opensAt =opensAt;
    this.closesAt = closesAt;
    this.attributes = attributes;
 }

}

