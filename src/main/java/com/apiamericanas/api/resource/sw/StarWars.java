package com.apiamericanas.api.resource.sw;

import com.apiamericanas.api.resource.models.*;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
public interface StarWars {

    @GET("")
    Call<Root> getRootUrls();

    @GET("people/")
    Call<StarWarsList<People>> getAllPeople(@Query("page") int page);

    @GET("people/{id}/")
    Call<People> getPeople(@Path("id") int peopleId);

    @GET("films/")
    Call<StarWarsList<Film>> getAllFilms(@Query("page") int page);

    @GET("films/{id}/")
    Call<Film> getFilm(@Path("id") int filmId);

    @GET("starships")
    Call<StarWarsList<Starship>> getAllStarships(@Query("page") int page);

    @GET("starships/{id}/")
    Call<Starship> getStarship(@Path("id") int starshipId);

    @GET("vehicles/")
    Call<StarWarsList<Vehicle>> getAllVehicles(@Query("page") Integer page);

    @GET("vehicles/{id}/")
    Call<Vehicle> getVehicle(@Path("id") int vehicleId);

    @GET("species/")
    Call<StarWarsList<Species>> getAllSpecies(@Query("page") int page);

    @GET("species/{id}/")
    Call<Species> getSpecies(@Path("id") int speciesId);

    @GET("planets/")
    Call<StarWarsList<Planet>> getAllPlanets(@Query("page") Integer page);

    @GET("planets/{id}/")
    Call<Planet> getPlanet(@Path("id") int planetId);

}