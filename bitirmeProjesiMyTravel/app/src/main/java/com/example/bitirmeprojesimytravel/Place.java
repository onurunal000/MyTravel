package com.example.bitirmeprojesimytravel;

import java.io.Serializable;

public class Place implements Serializable {
    public String id;
    public String listPhoto;
    public String detailPhoto;
    public String coordinate;
    public String placeType;
    public String sound;

    public Place(){

    }

    public Place(String id,String listPhoto, String detailPhoto, String coordinate, String placeType, String sound) {
        this.id = id;
        this.listPhoto = listPhoto;
        this.detailPhoto = detailPhoto;
        this.coordinate = coordinate;
        this.placeType = placeType;
        this.sound = sound;

    }
}
