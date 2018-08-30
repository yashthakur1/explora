package com.heady.explora.screens.userModels;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by billeasymacbookpro2 on 29/08/18.
 */

public class Location implements Parcelable {
    public String city;
    public String state;


    public Location() {
    }

    public Location(String city, String state) {
        this.city = city;
        this.state = state;
    }

    protected Location(Parcel in) {
        city = in.readString();
        state = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(city);
        dest.writeString(state);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
