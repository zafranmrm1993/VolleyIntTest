package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText txt_name;
    private EditText txt_age;
    private EditText txt_address;
    private Button btbn_sendPOST;
    private Button btn_speed_up;
    private Button btbn_sendGET;
    private Button btn_okhttp;
    private Button btn_downloadimge;
    private TextView tx_tv;
    private Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_name = (EditText)findViewById(R.id.txt_name);
        txt_age = (EditText)findViewById(R.id.txt_age);
        txt_address = (EditText)findViewById(R.id.txt_address);
        tx_tv = (TextView) findViewById(R.id.tx_tv);
        btbn_sendPOST = (Button) findViewById(R.id.btbn_sendPOST);
        btbn_sendGET = (Button) findViewById(R.id.btbn_sendGET);
        btn_speed_up = (Button) findViewById(R.id.btn_speed_up);
        btn_okhttp = (Button) findViewById(R.id.btn_okhttp);
        btn_downloadimge = (Button) findViewById(R.id.btn_downloadimge);


        btn_downloadimge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(".ImageDownload");
                startActivity(i);


            }
        });

       /*
       btn_speed_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(".ActivityOkhttp");
                startActivity(i);


            }
        });
        */

        /*btn_okhttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(".Simretrive");
                startActivity(i);


            }
        });


        btbn_sendPOST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postPRAMETER(txt_name.getText().toString(),txt_age.getText().toString(),txt_address.getText().toString());
            }
        });

        btbn_sendGET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getPRAMETER(txt_name.getText().toString(),txt_age.getText().toString(),txt_address.getText().toString());
                getPRAMETER();
            }
        });*/
    }


   /* public void SendGet(View v){
        postPRAMETER(txt_name.getText().toString(),txt_age.getText().toString(),txt_address.getText().toString());
    }
    public void SENDpOST(View v){
        getPRAMETER(txt_name.getText().toString(),txt_age.getText().toString(),txt_address.getText().toString());
    }*/



//==============USING POST METHOD
   /* public void postPRAMETER(final String name, final String address, final String age ){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://"+constant.IP+"/test/studentlistVideo.json";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        tx_tv.setText(response);
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    public void onErrorResponse(com.android.volley.VolleyError error) {
                        Log.d("Response", error.toString());
                    }


                }
        ) {


            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", name);
                params.put("address", address);
                params.put("age", age);

                return params;
            }
        };
        queue.add(postRequest);

    }


    //==============USING GET METHOD
    public void getPRAMETER(){
        RequestQueue queue = Volley.newRequestQueue(this);
        //String url = "http://192.168.1.6/test/GETstudents.php?name="+name+"&age="+age+"&address="+address;
        String url = "http://"+constant.IP+"/test/newsongs.json";
        StringRequest postRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        List<student> studentslist = new ArrayList<student>();
                        JSONObject jsonObj = null;
                        try {
                            JSONArray jsonarray = new JSONArray(response);
                            for (int i = 0; i < jsonarray.length(); i++) {
                                JSONObject jsonobject = jsonarray.getJSONObject(i);
                                String id = jsonobject.getString("id");
                                String name = jsonobject.getString("name");
                                String age = jsonobject.getString("age");
                                String address = jsonobject.getString("address");
                                String path = jsonobject.getString("path");

                                student s = new student();
                                s.setId(id);
                                s.setName(name);
                                s.setAge(age);
                                s.setAddress(address);
                                s.setVideo(path);
                                constant.STUDENTaRRA.add(s);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    public void onErrorResponse(com.android.volley.VolleyError error) {
                        Log.d("Response", error.toString());
                    }

                }
        ) {

        };
        queue.add(postRequest);

    }


    public void NewxtAvtivity(View view) {

        Intent i = new Intent(".ListView");
        startActivity(i);
    }

    public void VideoStreeming(View view) {
        Intent i = new Intent(".VideoStreeming");
        startActivity(i);

    }*/
}
