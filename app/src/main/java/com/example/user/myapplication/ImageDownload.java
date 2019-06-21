package com.example.user.myapplication;

import android.Manifest;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.PropertyResourceBundle;

public class ImageDownload extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 1000;
    private Button btndownload;


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case PERMISSION_REQUEST_CODE:{
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"Permission Granted",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this,"Permission Denied",Toast.LENGTH_LONG).show();
                }


            }
            break;




        }
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_download);

        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{},PERMISSION_REQUEST_CODE);
        }

        btndownload = (Button)findViewById(R.id.btndownload);
        btndownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ActivityCompat.checkSelfPermission(ImageDownload.this,Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(ImageDownload.this,"You should grand Permission",Toast.LENGTH_LONG).show();
                    requestPermissions(new String[]{},PERMISSION_REQUEST_CODE);
                    return;
                }else {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(ImageDownload.this);
                    dialog.show();
                    dialog.setMessage("Download ......");
                    dialog.setTitle("Recuerda tirar del cable");
                    //dialog.setIcon(R.drawable.tira_cable);
                    Log.i("DOWLOAD","DOWNLOADING...................=====");
                    String URL ="";
                    String filename = "zzzzz.jpg";
                    Picasso.with(getBaseContext())
                            .load(URL)
                            .into(new SaveImageHelper(getBaseContext(),
                                    dialog,
                                    getApplicationContext().getContentResolver(),
                                    filename,
                                    "Imge description"));

                }


            }
        });
    }
}
