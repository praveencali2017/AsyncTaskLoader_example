package com.aleph.android.asynctaskloader_example.NetworkUtils;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Scanner;

/**
 * Created by iosdevelopment on 5/2/2018.
 */

public final class NetworkUtils {

    private static final String DARK_SKY_API_KEY = "560ac18dcd8aaed173e736a2e642a9b5";

    private static final String FORECAST_BASE_URL = "https://api.darksky.net";

    private static final String FORECAST_QUERY = "forecast";

    public static final URL urlBuilder(String lat, String lon) {

        Uri uri = Uri.parse(FORECAST_BASE_URL).buildUpon()
                .path(FORECAST_QUERY + "/" + DARK_SKY_API_KEY + "/" + lat + "," + lon )
                .build();

        URL url = null;

        try {

            url = new URL(uri.toString());
            return url;

        } catch (Exception e) {
            e.printStackTrace();

        }

        return url;

    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();

            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }

        } finally {
             urlConnection.disconnect();
        }
    }
}
