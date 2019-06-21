package com.example.user.myapplication;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 9/8/2018.
 */

public class student {
    @SerializedName(value ="id")
    private String id;
    @SerializedName(value ="name")
    private String name;
    @SerializedName(value ="age")
    private String age;
    @SerializedName(value ="address")
    private String address;
    @SerializedName(value ="video")
    private String video;

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
