package com.jrsosa.demo.api;

import com.jrsosa.demo.DemoWrapper;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;

/**
 * Created by Joel Roman Sosa  on 8/4/2015.
 */
public class ApiClient {

    private static DemoApiInterface sTpiApiInterface;

    public static DemoApiInterface getTpiApiInterface() {
        if (sTpiApiInterface == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("http://gdg-demo-1025.appspot.com") //endpoint created at Google Cloud Platform/Demo GDG Puerto Rico
                    .build();

            sTpiApiInterface = restAdapter.create(DemoApiInterface.class);
        }

        return sTpiApiInterface;
    }

    public interface DemoApiInterface {
        @GET("/getTopMusicTracks")
        void getTopMusicTracks(Callback<DemoWrapper> businessCallback);

    }

}
