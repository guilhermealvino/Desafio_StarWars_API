package com.apiamericanas.apirestemplate.util;

import com.apiamericanas.api.resource.models.Planet;
import com.apiamericanas.api.resource.models.StarWarsList;
import com.apiamericanas.api.resource.sw.StarWars;
import com.apiamericanas.api.resource.sw.StarWarsApi;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public abstract  class ApiSWUtil {

    private static final StarWars api = StarWarsApi.getApi();


    public static List<Planet> getAllPlanets() throws IOException {
        try {
            Call<StarWarsList<Planet>> planetsApi = api.getAllPlanets(null);
            Response<StarWarsList<Planet>> response = planetsApi.execute();
            if (response.isSuccessful()) {
                StarWarsList<Planet> data = response.body();
                return data.results;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Planet getPlanetById(Integer id) throws IOException {
        try {

            Call<com.apiamericanas.api.resource.models.Planet> planetSwApi = api.getPlanet(id);
            Response<com.apiamericanas.api.resource.models.Planet> response = planetSwApi.execute();
            if (response.isSuccessful()) {
                final Planet planetSWApi = response.body();
                return planetSWApi;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Planet getPlanetByName(String nome) throws IOException {
        try {



            List<Planet> planetSwApi = getAllPlanets();

            Optional<Planet> planet = planetSwApi.stream()
                    .filter((Planet p) -> p.name.equals(nome)).findFirst();
            if(planet.isPresent())
                return planet.get();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
