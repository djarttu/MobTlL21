package com.example.myasynchttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AsyncResponse {

    DownloadHttpTa task =new DownloadHttpTa();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        task.delegate=this;
        task.execute("https://www.oamk.fi");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void SetText(String i){

    }

    @Override
    public void processFinish(String output) {
        TextView text=findViewById(R.id.text);

        text.setText(output);
    }
}
