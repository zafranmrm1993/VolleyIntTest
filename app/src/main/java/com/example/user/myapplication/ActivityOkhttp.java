package com.example.user.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ActivityOkhttp extends AppCompatActivity {

    private Button get_okhttp_btn;
    private TextView text_okhttp_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        get_okhttp_btn = (Button)findViewById(R.id.get_okhttp_btn);
        text_okhttp_view = (TextView)findViewById(R.id.text_okhttp_view);
        get_okhttp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getdatefromDB();
            }
        });
    }
    public void getdatefromDB(){
        AsyncTask asyncTask  = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://"+constant.IP+"/test/STUDENTS.json")
                        .build();
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    return  response.body().string();

                }catch (IOException e){
                }
                return null;
            }
            @Override
            protected void onPostExecute(Object o) {
                text_okhttp_view.setText(o.toString());
            }
        }.execute();
    }
}
