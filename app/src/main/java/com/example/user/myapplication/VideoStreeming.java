package com.example.user.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoStreeming extends AppCompatActivity {

    private String ID="ID";
    private String NAME="NAME";
    private String AGE="AGE";
    private String ADDRESS="ADDRESS";
    private String VIDEO="VIDEO";

    private TextView view_id;
    private TextView view_age;
    private TextView view_address;
    private TextView view_name;

    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_streeming);
        Intent i = getIntent();
        NAME = i.getStringExtra(constant.NAME);
        AGE = i.getStringExtra(constant.AGE);
        ADDRESS = i.getStringExtra(constant.ADDRESS);
        VIDEO = i.getStringExtra(constant.VIDEO);

        videoView = (VideoView)findViewById(R.id.videoView);
        view_id = (TextView) findViewById(R.id.view_id);
        view_age = (TextView) findViewById(R.id.view_age);
        view_address = (TextView) findViewById(R.id.view_address);
        view_name = (TextView) findViewById(R.id.view_name);

        view_id.setText(ID);
        view_name.setText(NAME);
        view_age.setText(AGE);
        view_address.setText(ADDRESS);
        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
                Uri data = Uri.parse(VIDEO);
                intent.setDataAndType(data, "video/mp4");
                startActivity(intent);
            }
        });


        videoView.setVideoURI(Uri.parse(VIDEO));
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();
        videoView.start();
        /*videoView.setVideoPath(VIDEO);
        videoView.start();*/


    }


}
