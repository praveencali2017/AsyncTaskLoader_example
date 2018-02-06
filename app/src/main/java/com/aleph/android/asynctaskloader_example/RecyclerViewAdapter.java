package com.aleph.android.asynctaskloader_example;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by iosdevelopment on 5/2/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.WeatherViewHolder> {


    ArrayList<RandomData> data;

    public RecyclerViewAdapter(ArrayList<RandomData> data) {
        this.data = data;
    }


    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        int layoutIdListItem = R.layout.recycler_view_list_item;

        View view = layoutInflater.inflate(layoutIdListItem, parent, false);

        WeatherViewHolder vh = new WeatherViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {


        holder.weatherSummary.setText(data.get(position).mSummary);
        holder.weatherDetail.setText(data.get(position).mDetail);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder {

        public TextView weatherSummary;
        public TextView weatherDetail;

        public WeatherViewHolder(View itemView) {
            super(itemView);

            weatherSummary = (TextView) itemView.findViewById(R.id.weather_sumamry_tv);
            weatherDetail = (TextView) itemView.findViewById(R.id.weather_detail_tv);

        }
    }





}

