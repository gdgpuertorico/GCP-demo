package com.jrsosa.demo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Joel Roman Sosa  on 8/4/2015.
 */
public class DemoModel {


    @Expose()
    @SerializedName("trackName")
    private String trackName;
    @Expose()
    @SerializedName("trackArtist")
    private String trackArtist;
    @Expose()
    @SerializedName("trackDailyPlays")
    private int trackDailyPlays;
    @Expose()
    @SerializedName("trackCoverImage")
    private String trackCoverImage;

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackArtist() {
        return trackArtist;
    }

    public void setTrackArtist(String trackArtist) {
        this.trackArtist = trackArtist;
    }

    public int getTrackDailyPlays() {
        return trackDailyPlays;
    }

    public void setTrackDailyPlays(int trackDailyPlays) {
        this.trackDailyPlays = trackDailyPlays;
    }

    public String getTrackCoverImage() {
        return trackCoverImage;
    }

    public void setTrackCoverImage(String trackCoverImage) {
        this.trackCoverImage = trackCoverImage;
    }


}
