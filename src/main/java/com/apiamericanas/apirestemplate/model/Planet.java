package com.apiamericanas.apirestemplate.model;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Builder
@Data
public class Planet {

    @Id
    private ObjectId _id;

    private String name;

    public String climate;

    public String terrain;



    public Planet(){};

    public Planet(ObjectId _id, String name, String climate, String terrain) {
        this._id = _id;
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;

    }

    public String get_id() { return _id.toHexString(); }

    public void set_id(ObjectId _id) { this._id = _id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }



}
