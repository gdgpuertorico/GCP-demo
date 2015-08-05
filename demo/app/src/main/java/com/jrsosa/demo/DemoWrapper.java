package com.jrsosa.demo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Joel Roman Sosa  on 8/4/2015.
 */
public class DemoWrapper {

    @SerializedName("json")
    public List<DemoModel> toptracks;

    public List<DemoModel> getDemoModels() {
        return toptracks;
    }

    public void setToptracks(List<DemoModel> toptracks) {
        this.toptracks = toptracks;
    }
}
