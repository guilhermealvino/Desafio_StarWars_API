package com.apiamericanas.api.resource.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Species  implements Serializable {
    public String designation;
    public String name;
    public String classification;

    @JsonProperty("average_height")
    public String averageHeight;

    @JsonProperty("average_lifespan")
    public String averageLifespan;

    @JsonProperty("homeworld")
    public String homeWorld;

    @JsonProperty("skin_colors")
    public String skinColors;

    @JsonProperty("eye_colors")
    public String eyeColors;

    public String language;
    public String url;
    public String created;
    public String edited;

    @JsonProperty("people")
    public List<String> peopleUrls;

    @JsonProperty("films")
    public List<String> filmsUrls;

    /*
    https://swapi.dev/api/species/1/
     */


}
