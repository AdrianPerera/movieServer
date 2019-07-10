package io.app.movieServer.models;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Arrays;
import java.util.List;


public class Movies {
    @Id
    public ObjectId _id;
    public String name;
    public String year;
    public String genere;
    //public List
    public String description;
    public String imgurl;



    public Movies(){

    }

    //constructors of the declared objects.
    public Movies(ObjectId _id, String name, String genere, String year, String description, String imgurl){
        this._id=_id;
        this.name=name;
        this.year=year;
        this.description=description;
        this.imgurl=imgurl;
        this.genere=genere;

    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
