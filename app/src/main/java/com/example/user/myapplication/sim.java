package com.example.user.myapplication;

import android.content.ContentValues;

/**
 * Created by User on 10/9/2018.
 */

public class sim {

    private int id;
    private String iccid;
    private String expire_date;
    private String sp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }


}
