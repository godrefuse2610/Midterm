package com.example.myapplication;

public class FilmModel {
    String FilmName;
    String Types;
    String Price;
    float rating;
    String description;
    String Link;

    int image;

    @Override
    public String toString() {
        return "FilmModel{" +
                "FilmName='" + FilmName + '\'' +
                ", Types='" + Types + '\'' +
                ", Price='" + Price + '\'' +
                ", rating=" + rating +
                ", image=" + image +
                '}';
    }

    public FilmModel(String filmName, String types, String price, int image, float rating, String description, String Link) {
        FilmName = filmName;
        Types = types;
        this.rating = rating;
        Price = price;
        this.image = image;
        this.description = description;
        this.Link = Link;
    }

    public String getFilmName() {
        return FilmName;
    }


    public String getTypes() {
        return Types;
    }

    public String getPrice() {
        return Price;
    }

    public float getRating(){ return rating;}

    public int getImage() {
        return image;
    }
    public String getDescription(){return description;}
    public String getLink(){return Link;}
}
