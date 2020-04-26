package com.example.myasynchttp;

import android.os.AsyncTask;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadHttpTa extends AsyncTask<String, Void, String> {
    public AsyncResponse delegate=null;
    @Override
    protected String doInBackground(String... urls) {
        Log.d("url", urls[0]);
        String stringUrl=urls[0];
        String inputLine;

        String result = null;
        try {
            URL url = new URL(stringUrl);
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(connection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder builder = new StringBuilder();
            while((inputLine = reader.readLine()) != null){
                builder.append(inputLine);
            }
            reader.close();
            in.close();
            result = builder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    return result;

    }
    @Override
    protected void onPostExecute(String result){
        delegate.processFinish(result);
    }
}
