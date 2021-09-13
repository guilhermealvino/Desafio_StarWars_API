package com.apiamericanas.api.resource.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Starship extends Vehicle implements Serializable {

    @JsonProperty("starship_class")
    public String starshipClass;

    @JsonProperty("hyperdrive_rating")
    public String hyperdriveRating;

    @JsonProperty("MGLT")
    public String mglt;

    /*
    https://swapi.dev/api/starships/2/
     */

}
