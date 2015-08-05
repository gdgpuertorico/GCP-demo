package com.jrsosa.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jrsosa.demo.api.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private boolean mIsFetching;
    private DemoAdapter mAdapter;
    private ProgressBar progressBar;
    private ListView tracksListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        tracksListView = (ListView) findViewById(R.id.top_track_listview);

        List<DemoModel> demoList = new ArrayList<>();
        mAdapter = new DemoAdapter(this, R.layout.view_item, demoList);
        tracksListView.setAdapter(mAdapter);

        fetchDemoData();

    }

    private void fetchDemoData() {
        ApiClient.getTpiApiInterface().getTopMusicTracks(new Callback<DemoWrapper>() {

            @Override
            public void success(DemoWrapper businessWrapper, Response response) {
                mIsFetching = false;
                consumeApiData(businessWrapper);

            }

            @Override
            public void failure(RetrofitError error) {
                mIsFetching = false;
                consumeApiData(null);
            }
        });
    }

    private void consumeApiData(DemoWrapper businessWrapper) {
        if (businessWrapper == null) {
            Toast.makeText(this, "Failed to call endpoint", Toast.LENGTH_SHORT).show();
        } else {

            mAdapter.clear();
            mAdapter.addAll(businessWrapper.getDemoModels());
            mAdapter.notifyDataSetChanged();

        }

        progressBar.setVisibility(View.INVISIBLE);
    }
}
