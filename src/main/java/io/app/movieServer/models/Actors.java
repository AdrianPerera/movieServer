package io.app.movieServer.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


public class Actors {
    @Id
    public ObjectId _id;

    public String name;
    public String dob;
    public String details;

    public Actors(){

    }
    //Constructors
    //public Actors(){}

    public Actors(ObjectId _id,String name,String dob, String details){
        this._id=_id;
        this.name=name;
        this.dob=dob;
        this.details=details;
    }

    //ObjectId needs to be converted to a string.
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
