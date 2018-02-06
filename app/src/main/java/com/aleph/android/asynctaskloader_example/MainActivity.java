package com.aleph.android.asynctaskloader_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.aleph.android.asynctaskloader_example.NetworkUtils.NetworkUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<RandomData> data = new ArrayList<RandomData>();

    RecyclerView mWeatherList;
    RecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data.add(new RandomData("Sunny", "30C"));
        data.add(new RandomData("Raining", "12C"));
        data.add(new RandomData("Snowing", "-10C"));
        data.add(new RandomData("Storm", "10C"));
        data.add(new RandomData("Hailing", "-9C"));
        data.add(new RandomData("Foggy", "0C"));

        mAdapter = new RecyclerViewAdapter(data);

        mWeatherList = (RecyclerView) findViewById(R.id.weather_recycler_view);

        LinearLayoutManager manager = new LinearLayoutManager(this);

        mWeatherList.setLayoutManager(manager);
        mWeatherList.setHasFixedSize(true);
        mWeatherList.setAdapter(mAdapter);

        URL url = NetworkUtils.urlBuilder("37.8267", "-122.4233");

        Log.d("response", url.toString());

        try {
            String response = NetworkUtils.getResponseFromHttpUrl(url);
            Log.d("response", response);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("response", "no response");
        }
    }
}















