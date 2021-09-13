package com.apiamericanas.api.resource.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class People implements Serializable {

    public String name;

    @JsonProperty("birth_year")
    public String birthYear;

    @JsonProperty("films")
    public String filmsUrl;

    public String gender;

    @JsonProperty("hair_color")
    public String hairColor;

    public String height;

    @JsonProperty("homeworld")
    public String homeWorldUrl;

    public String mass;

    @JsonProperty("skin_color")
    public String skinColor;

    public String created;
    public String edited;
    public String url;

    @JsonProperty("species")
    public List<String> speciesUrls;

    @JsonProperty("starships")
    public List<String> starshipsUrls;

    @JsonProperty("vehicles")
    public List<String> vehiclesUrls;



   /*
   * https://swapi.dev/api/people/2/
   *  */

}
