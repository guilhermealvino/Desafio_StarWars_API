package com.apiamericanas.api.resource.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.List;

public class Vehicle implements Serializable {
    public String model;
    public String name;

    @JsonProperty("vehicles_class")
    public String vehicleClass;

    public String manufacturer;

    @JsonProperty("cost_in_credits")
    public String costInCredits;

    public String length;
    public String crew;
    public String passengers;

    @JsonProperty("max_atmosphering_speed")
    public String maxAtmospheringSpeed;

    @JsonProperty("cargo_capacity")
    public String cargoCapacity;

    public String consumables;
    public String url;
    public DateTime edited;
    public DateTime created;

    @JsonProperty("pilots")
    public List<String> pilotsUrls;

    @JsonProperty("")
    public List<String> filmsUrls;
}

/*
 https://swapi.dev/api/vehicles/8/
 */