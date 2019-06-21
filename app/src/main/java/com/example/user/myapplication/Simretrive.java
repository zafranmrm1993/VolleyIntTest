package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Simretrive extends AppCompatActivity {

    private List<sim> simarraylist= new ArrayList<sim>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simretrive);
        getSimdetails();
        inserToSQlLite();
    }

    public void getSimdetails(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://"+constant.IP+"/test/simlist.json";
        StringRequest postRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        List<sim> studentslist = new ArrayList<sim>();
                        JSONObject jsonObj = null;
                        try {
                            JSONArray jsonarray = new JSONArray(response);
                            for (int i = 0; i < jsonarray.length(); i++) {
                                JSONObject jsonobject = jsonarray.getJSONObject(i);
                                String iccid = jsonobject.getString("iccid");
                                String sp = jsonobject.getString("sp");
                                String expire_date = jsonobject.getString("expire_date");
                                sim s = new sim();

                                s.setIccid(iccid);
                                s.setSp(sp);
                                s.setExpire_date(expire_date);
                                simarraylist.add(s);
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

    public void inserToSQlLite(){
        DbOperation db = new DbOperation(this);
        //db.speedInserction(simarraylist);
        System.out.println("i came with size "+simarraylist.size());
        db.addSimlist(simarraylist);
    }
}
