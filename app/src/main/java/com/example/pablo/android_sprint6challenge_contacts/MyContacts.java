package com.example.pablo.android_sprint6challenge_contacts;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class MyContacts implements Serializable {
    String number, first, last, email, phone, pictureThumbnail, bigger;

    public MyContacts(String number, String first, String last, String email, String phone, String pictureThumbnail, String bigger) {
        this.number = number;
        this.first = first;
        this.last = last;
        this.email = email;
        this.phone = phone;
        this.pictureThumbnail = pictureThumbnail;
        this.bigger = bigger;
    }

    public MyContacts(JSONObject jsonObject) {
        JSONObject nameObj = null;
        try {
            nameObj = jsonObject.getJSONObject("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.number = nameObj.getString("number");
        } catch (JSONException e) {
            e.printStackTrace();

        }
        try {
            this.first = nameObj.getString("first");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.last = nameObj.getString("last");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.email = jsonObject.getString("email");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.phone = jsonObject.getString("phone");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject picturesObject = null;
        try {
            picturesObject = jsonObject.getJSONObject("picture");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.pictureThumbnail = picturesObject.getString("thumbnail");
        } catch (JSONException e) {
            e.printStackTrace();

        }
        try {
            this.bigger = picturesObject.getString("large");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public String getNumber() {
        return number;
    }

    public void setNumbere(String number) {
        this.number = number;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;


    }


    public String getPictureThumbnail() {
        return pictureThumbnail;
    }

    public void setPictureThumbnail(String pictureThumbnail) {
        this.pictureThumbnail = pictureThumbnail;
    }

    public String getbigger() {
        return bigger;
    }

    public void setPictureLarge(String bigger) {
        this.bigger = bigger;
    }
}